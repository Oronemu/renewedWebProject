package web.application.notification;

public interface INotification {
    void send(String message);
    void setBroadcaster(IBroadcaster broadcaster);
}
