package web.application.authorization;

import web.application.authorization.user.IUserRepo;
import web.application.authorization.user.User;
import web.application.authorization.user.UserAlreadyExistsException;
import web.application.authorization.user.UserNotFoundException;

public interface IAuth {
    boolean signIn(User user) throws UserNotFoundException;
    boolean signUp(User user) throws UserAlreadyExistsException;
    boolean checkToken(String username, String token);
    String createToken(String username);
    void setUserRepo(IUserRepo userRepo);
    void setTokenService(ITokenService tokenService);
}
