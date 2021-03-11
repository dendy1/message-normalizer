package org.equilibrium.yandex;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.equilibrium.yandex.aws.YandexQueueCredentialsProvider;
import org.equilibrium.yandex.queue.SendMessageRequest;
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
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
}
