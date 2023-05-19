package web.infrastructure.repo.user;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import web.application.authorization.user.User;

@Entity
@Table(name = "\"users\"")
public class EUser implements Serializable {
    
    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "\"username\"", unique = true)
    private String username;

    @Column(name = "\"password\"")
    private String password;


    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAll(User user){
        setUsername(user.getUsername());
        setPassword(user.getPassword());
    }
}