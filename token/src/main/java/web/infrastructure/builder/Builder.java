package web.infrastructure.builder;

import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import web.application.token.ISender;
import web.application.token.IToken;
import web.application.token.ITokenService;

public class Builder {

    @Inject @Default
    private ITokenService tokenService;

    @Inject @Default
    private ISender sender;

    @Inject @Default
    private IToken token;

    @Produces @Built
    public IToken buildIToken(){
        token.setSender(sender);
        token.setTokenService(tokenService);
        return token;
    }
}
