package org.equilibrium.stomp;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        yandexQueue.sendMessage(new SendMessageRequest(
                "queue-test",
                frame.getBody()
        ));
        return Response.status(200).build();
    }
}
