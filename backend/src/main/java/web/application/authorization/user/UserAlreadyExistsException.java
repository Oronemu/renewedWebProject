package web.application.authorization.user;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
