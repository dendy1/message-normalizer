package org.equilibrium.api.yandex;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.equilibrium.api.yandex.data.YandexQueueCredentialsProvider;
import org.equilibrium.api.yandex.data.message.SendMessageRequest;
import org.equilibrium.api.yandex.data.queue.CreateQueueRequest;
import org.equilibrium.api.yandex.data.queue.DeleteQueueRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.jms.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class YandexQueue {

    @ConfigProperty(name = "yandex-queue.aws_access_key_id")
    String awsAccessKeyId;

    @ConfigProperty(name = "yandex-queue.aws_secret_access_key")
    String awsSecretAccessKey;

    private static final Logger logger = LoggerFactory.getLogger(YandexQueue.class);

    private static final String SERVICE_ENDPOINT = "https://message-queue.api.cloud.yandex.net";
    private static final String REGION_NAME = "ru-central1";

    SQSConnectionFactory connectionFactory;
    SQSConnection connection;
    AmazonSQSMessagingClientWrapper client;

    private SQSConnectionFactory getConnectionFactory() {

        if (connectionFactory == null) {
            connectionFactory = new SQSConnectionFactory(
                    new ProviderConfiguration(),
                    AmazonSQSClientBuilder.standard()
                            .withRegion(REGION_NAME)
                            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                                    SERVICE_ENDPOINT,
                                    REGION_NAME
                            ))
                            .withCredentials(new YandexQueueCredentialsProvider(awsAccessKeyId, awsSecretAccessKey))
            );
        }

        return connectionFactory;
    }

    private SQSConnection getConnection() throws JMSException {

        if (connection == null) {
            connection = getConnectionFactory().createConnection();
        }

        return connection;
    }

    private AmazonSQSMessagingClientWrapper getClient() throws JMSException {

        if (client == null) {
            client = getConnection().getWrappedAmazonSQSClient();
        }

        return client;
    }

    public Response sendMessage(SendMessageRequest request) {
        try {
            if (!getClient().queueExists(request.getQueueName())) {
                return Response.status(404).entity("Yandex Queue with this name not found").build();
            }

            Session session = getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(request.getQueueName());

            MessageProducer producer = session.createProducer(queue);
            Message message = session.createTextMessage(request.getMessageBody());
            producer.send(message);

            logger.info("Message successfully sent to queue");
            return Response.status(200).build();
        } catch (JMSException ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    public Response createQueue(CreateQueueRequest request) {
        try {
            if (getClient().queueExists(request.getQueueName())) {
                return Response.status(409).entity("Yandex Queue with this name already exist").build();
            }

            CreateQueueResult result = getClient().createQueue(new com.amazonaws.services.sqs.model.CreateQueueRequest()
                    .withQueueName(request.getQueueName())
                    .withAttributes(request.getAttributes())
            );

            logger.info("Queue successfully created");
            return Response.status(200).entity(result).build();
        } catch (JMSException ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    public Response deleteQueue(DeleteQueueRequest request) {
        try {
            if (request.getQueueUrl() == null) {
                GetQueueUrlResult urlResult = getClient().getQueueUrl(request.getQueueName());
                request.setQueueUrl(urlResult.getQueueUrl());
            }

            DeleteQueueResult deleteResult = getClient().getAmazonSQSClient().deleteQueue(
                    new com.amazonaws.services.sqs.model.DeleteQueueRequest()
                            .withQueueUrl(request.getQueueUrl())
            );

            logger.info("Queue deleted");
            return Response.status(200).entity(deleteResult).build();
        } catch (JMSException ex) {
            return Response.serverError().entity(ex).build();
        }
    }
}
