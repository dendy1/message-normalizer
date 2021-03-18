package org.equilibrium.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.equilibrium.api.emqx.EMQXApi;
import org.equilibrium.api.emqx.data.acl.CreateACLRuleRequest;
import org.equilibrium.api.emqx.data.acl.CreateACLRuleResponse;
import org.equilibrium.api.emqx.data.auth.CreateUserRequest;
import org.equilibrium.api.emqx.data.auth.CreateUserResponse;
import org.equilibrium.api.emqx.data.resources.CreateResourceRequest;
import org.equilibrium.api.emqx.data.resources.CreateResourceResponse;
import org.equilibrium.api.emqx.data.rules.CreateRuleRequest;
import org.equilibrium.api.emqx.data.rules.CreateRuleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/emqx")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EMQXResource {

    public static Logger logger = LoggerFactory.getLogger(EMQXResource.class);

    @Inject
    @RestClient
    EMQXApi emqxApi;

    @Path("/users")
    @POST
    public Response createUser(CreateUserRequest request) {
        CreateUserResponse response = emqxApi.createUser(request);
        return Response.status(200).entity(response).build();
    }

    @Path("/acl_rules")
    @POST
    public Response createACLRule(CreateACLRuleRequest request) {
        CreateACLRuleResponse response = emqxApi.createACLRule(request);
        return Response.status(200).entity(response).build();
    }

    @Path("/rules")
    @POST
    public Response createRule(CreateRuleRequest request) {
        CreateRuleResponse response = emqxApi.createRule(request);
        return Response.status(200).entity(response).build();
    }

    @Path("/resources")
    @POST
    public Response createResource(CreateResourceRequest request) {
        CreateResourceResponse response = emqxApi.createResource(request);
        return Response.status(200).entity(response).build();
    }
}
