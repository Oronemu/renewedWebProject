package web.infrastructure.repo.post;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import web.application.article.post.Post;

@Entity
@Table(name = "\"posts\"")
public class EPost implements Serializable {
    
    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "\"title\"")
    private String title;

    @Column(name = "\"author\"")
    private String author;

    @Column(name = "\"text\"")
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "\"date\"")
    private Date date;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setAll(Post post){
        setAuthor(post.getAuthor());
        setDate(post.getDate());
        setText(post.getText());
        setTitle(post.getTitle());
    }
}
