package web.application.authorization.user;

public interface IUserRepo {
    boolean add(User user) throws UserAlreadyExistsException;
    boolean check(User user) throws UserNotFoundException;
}
