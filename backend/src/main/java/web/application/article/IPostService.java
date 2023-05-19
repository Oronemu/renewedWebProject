package web.application.article;

import java.util.List;

import web.application.article.post.IPostRepo;
import web.application.article.post.Post;

public interface IPostService {
    boolean publish(Post post);
    List<Post> getAll();
    List<Post> getByAuthor(String author);
    void setPostRepo(IPostRepo postRepo);
}
