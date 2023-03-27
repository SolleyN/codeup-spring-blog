import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import  org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/posts")
public class PostController {

    // Method to show all posts
    @GetMapping("")
    public String index(Model model) {
        // Create a list of posts
        List<Post> posts = new ArrayList<>();

        // Add two post objects to the list
        posts.add(new Post("First Post", "This is the first post."));
        posts.add(new Post("Second Post", "This is the second post."));

        // Add the list to the model
        model.addAttribute("posts", posts);

        // Return the view
        return "posts/index";
    }

    // Method to show one post
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        // Create a post object
        Post post = new Post("First Post", "This is the first post.");

        // Add the post to the model
        model.addAttribute("post", post);

        // Return the view
        return "posts/show";
    }
}

