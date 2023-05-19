package web.application.authorization;

public interface ITokenService {
    String create(String username);
    boolean check(String username, String token);
}
