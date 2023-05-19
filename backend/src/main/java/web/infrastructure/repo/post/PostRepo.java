package web.infrastructure.repo.post;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.application.article.post.IPostRepo;
import web.application.article.post.Post;

@Stateless
public class PostRepo implements IPostRepo {

    @PersistenceContext(unitName = "Postgres")
    private EntityManager entityManager;

    @Override
    public boolean add(Post post) {
        try {
            EPost ePost = new EPost();
            ePost.setAll(post);
            entityManager.persist(ePost);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Post> getAll() {
        try {
            List<EPost> ePosts = entityManager
            .createQuery("SELECT p FROM EPost p", EPost.class)
            .getResultList();
            List<Post> posts = new ArrayList<>();
            for (EPost ePost : ePosts) {
                Post post = new Post();
                post.setAuthor(ePost.getAuthor());
                post.setDate(ePost.getDate());
                post.setText(ePost.getText());
                post.setTitle(ePost.getTitle());
                posts.add(post);
            }
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Post> getByAuthor(String author) {
        try {
            List<EPost> ePosts = entityManager
            .createQuery("SELECT p FROM EPost p WHERE p.author = :author", EPost.class)
            .setParameter("author", author)
            .getResultList();
            List<Post> posts = new ArrayList<>();
            for (EPost ePost : ePosts) {
                Post post = new Post();
                post.setAuthor(ePost.getAuthor());
                post.setDate(ePost.getDate());
                post.setText(ePost.getText());
                post.setTitle(ePost.getTitle());
                posts.add(post);
            }
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
