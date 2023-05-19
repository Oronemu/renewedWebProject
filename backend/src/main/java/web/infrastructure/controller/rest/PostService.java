package web.infrastructure.controller.rest;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import web.application.article.IPostService;
import web.application.article.post.Post;
import web.infrastructure.builder.Built;
import web.infrastructure.interceptor.TokenRequired;

@Path("/posts")
public class PostService {
    
    private Jsonb jsonb = JsonbBuilder.create();

    @Inject @Built
    private IPostService postService;

    @POST
    @TokenRequired
    @Consumes("application/json")
    @Produces("application/json")
    public Response publishPost(String json){
        Post post = jsonb.fromJson(json, Post.class);
        if(postService.publish(post)){
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @GET
    @TokenRequired
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAllPosts(){
        List<Post> posts = postService.getAll();
        return Response.ok(jsonb.toJson(posts)).build();
    }

    @GET
    @TokenRequired
    @Path("/{author}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPostsByAuthor(@PathParam("author") String author){
        List<Post> posts = postService.getByAuthor(author);
        return Response.ok(jsonb.toJson(posts)).build();
    }
}
