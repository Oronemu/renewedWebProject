package web.infrastructure.token;

import java.security.Key;

import web.application.token.ITokenService;

public class TokenService implements ITokenService {

    private static final TokenKey tokenKey = new TokenKey();
    private static final Key key = tokenKey.getKey();
    
    @Override
    public String create(String username){
        TokenIssuer tokenIssuer = new TokenIssuer(key);
        return tokenIssuer.issueToken(username);
    }

    @Override
    public boolean check(String username, String token){
        TokenValidator tokenValidator = new TokenValidator(key);
        return username.equals(tokenValidator.validate(token));
    }
}
