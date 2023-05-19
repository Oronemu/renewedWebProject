package web.application.token;

public interface ISender {
    void sendCheck(boolean check);
    void sendToken(String token);
}
