package org.equilibrium.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mqtt")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MqttResource {

    private static Logger logger = LoggerFactory.getLogger(MqttResource.class);

    @POST
    public String sendMessage(String message) {
        logger.info(message);
        return message;
    }
}
