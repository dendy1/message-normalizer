package org.equilibrium.stomp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.equilibrium.YandexMessagePayload;
import org.equilibrium.configuration.ConfigurationStorage;
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

@Path("/stomp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StompResource {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static Logger logger = LoggerFactory.getLogger(StompResource.class);

    @Inject
    YandexQueue yandexQueue;

    @POST
    public Response sendMessage(StompFrame frame) {

        try {
            YandexMessagePayload payload = new YandexMessagePayload(
                    "user-id-uuid",
                    "project-id-uuid",
                    frame.getDestination(),
                    frame.getBody(),
                    System.currentTimeMillis()
            );

            yandexQueue.sendMessage(new SendMessageRequest(
                    ConfigurationStorage.getInternalTopic(frame.getDestination()),
                    objectMapper.writeValueAsString(payload)
            ));
        } catch (JsonProcessingException e) {
            logger.error("", e);
            return Response.serverError().entity("Unable to parse json").build();
        }

        yandexQueue.sendMessage(new SendMessageRequest(
                "queue-test",
                frame.getBody()
        ));
        return Response.status(200).build();
    }
}
