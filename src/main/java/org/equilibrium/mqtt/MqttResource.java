package org.equilibrium.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.equilibrium.mqtt.response.EMQXResponse;
import org.equilibrium.yandex.queue.YandexQueueApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/mqtt")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MqttResource {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static Logger logger = LoggerFactory.getLogger(MqttResource.class);

    @POST
    public String sendMessage(EMQXResponse message) {

        for (Map.Entry<String, String> payloadEntry: message.getPayload().entrySet()) {
            logger.info("\"{}\": \"{}\"", payloadEntry.getKey(), payloadEntry.getValue());
        }

        return message.getPayload().get("payload");
    }
}
