import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String listPosts() {
        return "This page will display a list of all blog posts.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable Long id) {
        return "This page will display the details of blog post with ID: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "This page will display a form to create a new blog post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This page will create a new blog post and redirect to the new post's detail page.";
    }
}
