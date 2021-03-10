package org.equilibrium.yandex.queue;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@RegisterRestClient(configKey = "yandex-queue")
@ClientHeaderParam(name = "Authorization", value = "")
public interface YandexQueueApi {

    @POST
    String sendMessage(
            @DefaultValue("SendMessage") @FormParam("Action") String action,
            @DefaultValue("2012-11-05") @FormParam("Version") String version,
            @FormParam("QueueUrl") String queueUrl,
            @FormParam("MessageBody") String messageBody
    );

    @POST
    String sendMessage(
            @DefaultValue("SendMessage") @FormParam("Action") String action,
            @DefaultValue("2012-11-05") @FormParam("Version") String version,
            @FormParam("QueueUrl") String queueUrl,
            @FormParam("MessageBody") String messageBody,
            @FormParam("DelaySeconds") Integer delaySeconds
    );
}
