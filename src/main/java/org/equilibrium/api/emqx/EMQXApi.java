package org.equilibrium.api.emqx;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.equilibrium.api.emqx.data.acl.*;
import org.equilibrium.api.emqx.data.auth.*;
import org.equilibrium.api.emqx.data.resources.CreateResourceRequest;
import org.equilibrium.api.emqx.data.resources.CreateResourceResponse;
import org.equilibrium.api.emqx.data.resources.DeleteResourceResponse;
import org.equilibrium.api.emqx.data.resources.GetResourceResponse;
import org.equilibrium.api.emqx.data.rules.*;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "emqx")
@Path("/api/v4")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ClientHeaderParam(name = "Authorization", value = "{auth}")
public interface EMQXApi {

    default String auth() {
        return "Basic YWRtaW46cHVibGlj";
    }

    // Mnesia Authentication
    // Check the created authentication data
    @GET
    @Path("/mqtt_user")
    GetUsersResponse getUsers();

    // Check the specified authentication data
    @GET
    @Path("/mqtt_user/{login}")
    GetUserResponse getUser(@PathParam String login);

    // Create authentication data
    @POST
    @Path("/mqtt_user")
    CreateUserResponse createUser(CreateUserRequest request);

    // Update the added authentication data
    @PUT
    @Path("/mqtt_user/{login}")
    UpdateUserResponse updateUser(@PathParam String login, UpdateUserRequest request);

    // Delete the added authentication data
    @DELETE
    @Path("/mqtt_user/{login}")
    DeleteUserResponse deleteUser(@PathParam String login);


    // Mnesia ACL
    // Check the created ACL rules
    @GET
    @Path("/mqtt_acl")
    GetACLRulesResponse getACLRules();

    // Check the specified ACL rule
    @GET
    @Path("/mqtt_acl/{login}")
    GetACLRulesResponse getACLRules(@PathParam String login);

    // Create ACL rule
    @POST
    @Path("/mqtt_acl")
    CreateACLRuleResponse createACLRule(CreateACLRuleRequest request);

    // Delete ACL rule
    @DELETE
    @Path("/mqtt_acl/{login}/{topic}")
    DeleteACLRuleResponse deleteACLRule(@PathParam String login, @PathParam String topic);


    // Query ule engine actions
    // Get a rule.
    @GET
    @Path("/rules/{ruleId}")
    GetRuleResponse getRule(@PathParam String ruleId);

    // Create a rule and return the rule ID.
    @POST
    @Path("/rules")
    CreateRuleResponse createRule(CreateRuleRequest request);

    // Create a rule and return the rule ID.
    @PUT
    @Path("/rules/{ruleId}")
    UpdateRuleResponse updateRule(@PathParam String ruleId, UpdateRuleRequest request);

    // Delete a rule.
    @DELETE
    @Path("/rules/{ruleId}")
    DeleteRuleResponse deleteRule(@PathParam String ruleId);


    // Manage the resources of the rules engine. A resource is an instance of a resource type and is used to maintain related resources such as database connections.
    // Get a resource.
    @GET
    @Path("/resources/{resourceId}")
    GetResourceResponse getResource(@PathParam String resourceId);

    // Create a resource.
    @POST
    @Path("/resources")
    CreateResourceResponse createResource(CreateResourceRequest request);

    // Delete a resource.
    @DELETE
    @Path("/resources/{resourceId}")
    DeleteResourceResponse deleteResource(@PathParam String resourceId);
}
