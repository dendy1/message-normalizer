package org.equilibrium.yandex;

import org.equilibrium.yandex.queue.YandexQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/yandex")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class YandexResource {

    private static final Logger logger = LoggerFactory.getLogger(YandexResource.class);

    @Inject
    YandexQueue yandexQueue;

    @POST
    @Path("/send")
    public String sendMessage(@FormParam("QueueUrl") String queueUrl, @FormParam("MessageBody") String messageBody) {
        return yandexQueue.sendMessage(queueUrl, messageBody);
    }
}
