package web.infrastructure.controller.rest;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import web.application.authorization.IAuth;
import web.application.authorization.user.User;
import web.application.authorization.user.UserAlreadyExistsException;
import web.application.authorization.user.UserNotFoundException;
import web.infrastructure.builder.Built;

@Path("/users")
public class UserService {

    private Jsonb jsonb = JsonbBuilder.create();

    @Inject @Built
    private IAuth auth;

    private String getToken(User user){
        return jsonb.toJson(auth.createToken(user.getUsername()));
    }

    private String getError(String error){
        return jsonb.toJson(error);
    }
    
    @POST
    @Path("/signUp")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createUser(String json){
        User user = jsonb.fromJson(json, User.class);
        boolean isSighUp = false;
        try {
            isSighUp = auth.signUp(user);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(getError(e.getMessage())).build();
        }
        return isSighUp ? Response.ok(getToken(user)).build() : Response.serverError().build();
    }

    @POST
    @Path("/signIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response checkUser(String json){
        User user = jsonb.fromJson(json, User.class);
        boolean isSignIn = false;
        try {
            isSignIn = auth.signIn(user);
        } catch(UserNotFoundException e){
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).entity(getError(e.getMessage())).build();
        }
        return isSignIn ? Response.ok(getToken(user)).build() : Response.serverError().build();
    }
}
