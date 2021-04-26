package org.equilibrium.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.equilibrium.api.yandex.YandexQueue;
import org.equilibrium.api.yandex.data.message.SendMessageRequest;
import org.equilibrium.configuration.ConfigurationStorage;
import org.equilibrium.data.NormalizedTopic;
import org.equilibrium.data.mqtt.EMQXResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mqtt")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MqttResource {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger logger = LoggerFactory.getLogger(MqttResource.class);

    @Inject
    YandexQueue yandexQueue;

    @Inject
    ConfigurationStorage configurationStorage;

    @POST
    public Response sendMessage(EMQXResponse message) {
        logger.info("Resending EMQX message to Yandex Message Queue");
        /*
        YandexMessagePayload payload = new YandexMessagePayload(
                "user-id-uuid",
                "project-id-uuid",
                message.getTopic(),
                message.getPayLoadString(),
                System.currentTimeMillis()
        );
         */

        NormalizedTopic topic = configurationStorage.getInternalTopic(message.getTopic());

        yandexQueue.sendMessage(new SendMessageRequest(
                topic.getQueueName(),
                message.getPayLoadString(),
                topic.getYandexQueueAttributes()
        ));

        logger.info("MQTT Message successfully sent");
        return Response.status(200).build();
    }
}
