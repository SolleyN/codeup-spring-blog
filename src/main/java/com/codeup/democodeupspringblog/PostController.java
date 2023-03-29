package com.codeup.democodeupspringblog;

import com.codeup.democodeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.democodeupspringblog.repositories.PostRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class PostController {
    private PostRepositories postsDao;

    public PostController(PostRepositories postsDao) {
        this.postsDao = postsDao;
    }

    // Method to show all posts


    // Method to show all posts
    @GetMapping("/posts/all")
    public String index(Model model) {
        // Get all posts from the database
        List<Post> posts = postsDao.findAll();

        model.addAttribute("posts", posts);

        // Return the view
        return "posts/index";
    }


    // Method to show one post
    @GetMapping("/posts/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        // Create a post object
        Post post = new Post("First Post", "This is the first post.");

        // Add the post to the model
        model.addAttribute("post", post);

        // Return the view
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm() {

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        System.out.println("title = " + title);
        System.out.println("body = " + body);

        // create post in the database
        Post post = new Post(title, body);
        postsDao.save(post);

        // redirect to the post show page
        return "redirect:/posts/all";
    }
}


