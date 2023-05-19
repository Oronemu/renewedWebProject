package web.application.authorization;

import web.application.authorization.user.IUserRepo;
import web.application.authorization.user.User;
import web.application.authorization.user.UserAlreadyExistsException;
import web.application.authorization.user.UserNotFoundException;

public class Auth implements IAuth {

    private ITokenService tokenService;
    private IUserRepo userRepo;

    @Override
    public boolean signIn(User user) throws UserNotFoundException {
        return userRepo.check(user);
    }

    @Override
    public boolean signUp(User user) throws UserAlreadyExistsException {
        return userRepo.add(user);
    }

    @Override
    public boolean checkToken(String username, String token) {
        return tokenService.check(username, token);
    }

    @Override
    public String createToken(String username) {
        return tokenService.create(username);
    }

    @Override
    public void setUserRepo(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void setTokenService(ITokenService tokenService) {
        this.tokenService = tokenService;
    }
}
