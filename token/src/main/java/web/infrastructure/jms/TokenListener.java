package web.infrastructure.jms;

import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import web.application.token.IToken;
import web.infrastructure.builder.Built;

@MessageDriven(mappedName = "jms/TokenQueue")
public class TokenListener implements MessageListener {

    @Inject @Built
    private IToken iToken;

    @Override
    public void onMessage(Message message) {
        try {
            String type = message.getJMSType();
            switch (type) {
                case "check":
                    {
                        String username = message.getStringProperty("username");
                        String token = message.getStringProperty("token");
                        iToken.check(username, token);
                        break;
                    }
                case "token":
                    {
                        String username = message.getStringProperty("username");
                        iToken.create(username);
                        break;
                    }
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
}
