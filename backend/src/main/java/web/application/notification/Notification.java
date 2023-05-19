package web.application.notification;

public class Notification implements INotification {

    private IBroadcaster broadcaster;

    @Override
    public void send(String message) {
        broadcaster.send(message);
    }

    @Override
    public void setBroadcaster(IBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }
    
}
