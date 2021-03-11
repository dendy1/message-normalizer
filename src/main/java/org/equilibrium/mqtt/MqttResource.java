package org.equilibrium.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        logger.info(message.getPayLoadString());
        yandexQueue.sendMessage(new SendMessageRequest(
                "queue-test",
                message.getPayLoadString()
        ));
        return Response.status(200).build();
    }
}
