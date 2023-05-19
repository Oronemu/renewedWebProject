package web.infrastructure.jms;

import jakarta.annotation.Resource;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Message;
import jakarta.jms.Queue;
import web.application.authorization.ITokenService;

public class Token implements ITokenService {

    @Resource(mappedName = "jms/ConnectionPool")    
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/TokenQueue")
    private Queue tokenQueue;

    @Resource(mappedName = "jms/HabrQueue")
    private Queue habrQueue;

    @Override
    public String create(String username) {
        try {
            JMSContext context = connectionFactory.createContext();
            JMSProducer producer = context.createProducer();     
            JMSConsumer consumer = context.createConsumer(habrQueue);       
            Message message = context.createMessage();
            message.setJMSType("token");
            message.setStringProperty("username", username);
            producer.send(tokenQueue, message);
            Message answer = consumer.receive(); 
            String token = answer.getStringProperty("token");
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean check(String username, String token) {
        try {
            JMSContext context = connectionFactory.createContext();
            JMSProducer producer = context.createProducer();     
            JMSConsumer consumer = context.createConsumer(habrQueue);       
            Message message = context.createMessage();
            message.setJMSType("check");
            message.setStringProperty("username", username);
            message.setStringProperty("token", token);
            producer.send(tokenQueue, message);
            Message answer = consumer.receive(); 
            Boolean check = answer.getBooleanProperty("check");
            return check;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
