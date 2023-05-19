package web.infrastructure.builder;

import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import web.application.article.IPostService;
import web.application.article.post.IPostRepo;
import web.application.authorization.IAuth;
import web.application.authorization.ITokenService;
import web.application.authorization.user.IUserRepo;
import web.application.notification.IBroadcaster;
import web.application.notification.INotification;

public class Builder {

    @Inject @Default
    private IAuth auth;

    @Inject @Default
    private IUserRepo userRepo;

    @Inject @Default
    private ITokenService tokenService;

    @Produces @Built
    public IAuth buildAuth(){
        auth.setTokenService(tokenService);
        auth.setUserRepo(userRepo);
        return auth;
    }

    @Inject @Default
    private IPostRepo postRepo;

    @Inject @Default
    private IPostService postService;

    @Produces @Built
    public IPostService buildIPostService(){
        postService.setPostRepo(postRepo);
        return postService;
    }

    @Inject @Default
    private INotification notification;

    @Inject @Default
    private IBroadcaster broadcaster;

    @Produces @Built
    public INotification buildINotification(){
        notification.setBroadcaster(broadcaster);
        return notification;
    }
}
