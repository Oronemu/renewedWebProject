package web.application.article;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import web.application.article.post.IPostRepo;
import web.application.article.post.Post;

public class PostService implements IPostService {

    private IPostRepo postRepo;

    @Override
    public boolean publish(Post post) {
        post.setDate(new Date());
        return postRepo.add(post);
    }

    @Override
    public void setPostRepo(IPostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public List<Post> getByAuthor(String author) {
        return postRepo.getByAuthor(author);
    }
    
}
