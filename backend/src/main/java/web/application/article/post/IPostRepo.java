package web.application.article.post;

import java.util.List;

public interface IPostRepo {
    boolean add(Post post);
    List<Post> getAll();
    List<Post> getByAuthor(String author);
}
