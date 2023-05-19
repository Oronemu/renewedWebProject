package web.application.token;

public interface IToken {
    void create(String username);
    void check(String username, String token);
    void setSender(ISender sender);
    void setTokenService(ITokenService tokenService);
}
