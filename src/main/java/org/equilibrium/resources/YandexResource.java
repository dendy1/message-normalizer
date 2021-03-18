package org.equilibrium.resources;

import org.equilibrium.api.yandex.YandexQueue;
import org.equilibrium.api.yandex.data.message.SendMessageRequest;
import org.equilibrium.api.yandex.data.queue.CreateQueueRequest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/yandex")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class YandexResource {

}
