package web.infrastructure.interceptor;

import java.io.IOException;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import web.application.authorization.IAuth;

@Provider
@TokenRequired
public class Interceptor implements ContainerRequestFilter {

    @Inject
    private IAuth auth;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String username = requestContext.getHeaderString("username");
        String token = requestContext.getHeaderString("token");
        if (!auth.checkToken(username, token)) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }
    } 
}
