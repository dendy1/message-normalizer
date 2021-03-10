package org.equilibrium.yandex.queue;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;

@ApplicationScoped
public class YandexQueue {

    @Inject
    @RestClient
    YandexQueueApi yandexQueueApi;

    public String sendMessage(
            @FormParam("QueueUrl") String queueUrl,
            @FormParam("MessageBody") String messageBody
    ) {
        return yandexQueueApi.sendMessage("SendMessage", "2012-11-05", queueUrl, messageBody);
    }

    public String sendMessage(
            @FormParam("QueueUrl") String queueUrl,
            @FormParam("MessageBody") String messageBody,
            @FormParam("DelaySeconds") Integer delaySeconds
    ) {
        return yandexQueueApi.sendMessage("SendMessage", "2012-11-05", queueUrl, messageBody, delaySeconds);
    }
}
