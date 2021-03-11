package org.equilibrium.yandex;

import org.equilibrium.yandex.queue.SendMessageRequest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/yandex")
@Consumes(MediaType.APPLICATION_JSON)
public class YandexResource {

    @Inject
    YandexQueue yandexQueue;

    @POST
    @Path("/send")
    public Response sendMessage(SendMessageRequest request) {
        return yandexQueue.sendMessage(request);
    }
}
