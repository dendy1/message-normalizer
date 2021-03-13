package org.equilibrium.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.equilibrium.YandexMessagePayload;
import org.equilibrium.configuration.ConfigurationStorage;
import org.equilibrium.mqtt.emqx.EMQXResponse;
import org.equilibrium.yandex.YandexQueue;
import org.equilibrium.yandex.queue.SendMessageRequest;
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
    public static Logger logger = LoggerFactory.getLogger(MqttResource.class);

    @Inject
    YandexQueue yandexQueue;

    @POST
    public Response sendMessage(EMQXResponse message) {
        logger.info("Resending EMQX message to Yandex Message Queue");
        try {
            YandexMessagePayload payload = new YandexMessagePayload(
                    "user-id-uuid",
                    "project-id-uuid",
                    message.getTopic(),
                    message.getPayLoadString(),
                    System.currentTimeMillis()
            );


            yandexQueue.sendMessage(new SendMessageRequest(
                    ConfigurationStorage.getInternalTopic(message.getTopic()),
                    objectMapper.writeValueAsString(payload)
            ));
        } catch (JsonProcessingException e) {
            logger.error("", e);
            return Response.serverError().entity("Unable to parse json").build();
        }

        return Response.status(200).build();
    }
}
