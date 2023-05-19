package web.infrastructure.controller.websocket;

import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import web.application.notification.IBroadcaster;

@ServerEndpoint(value = "/notifications")
public class NotificationService implements IBroadcaster {

    private final static ConcurrentLinkedQueue<Session> queue = new ConcurrentLinkedQueue<>();

    @OnOpen
    public void onOpen(Session session){
        queue.add(session);
    }

    @OnClose
    public void onClose(Session session){
        queue.remove(session);
    }   

    @Override
    public void send(String message) {
        queue.forEach(session -> {
            synchronized (session){
                try {
                    session.getBasicRemote().sendObject(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
}
