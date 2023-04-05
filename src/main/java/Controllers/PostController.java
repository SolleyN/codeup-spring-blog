package Controllers;

import com.codeup.democodeupspringblog.models.Post;
import com.codeup.democodeupspringblog.models.User;
import com.codeup.democodeupspringblog.repositories.PostRepositories;
import com.codeup.democodeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;




@Controller
public class PostController {
    private PostRepositories postsDao;
    private UserRepository userDao;
    private EmailService emailService;


    public PostController(PostRepositories postsDao, UserRepository userDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }
    @GetMapping("/")
    public String Welcome() {
        emailService.prepareAndSend(
                new Post(),
                "Welcome to my blog!",
                "This is the body of the email"
        );
        return "home";
    }
    @GetMapping("/posts/all")
    public String index(Model model) {

        List<Post> posts = postsDao.findAll();

        model.addAttribute("posts", posts);


        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Post post = new Post("First Post", "This is the first post.");
        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createAPostView(Model model) {
        model.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts/all";
    }
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post postToEdit = postsDao.findById(id).get();
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post, @PathVariable long id) {
        Post p = postsDao.getOne(id);
        p.setTitle(p.getTitle());
        p.setBody(p.getBody());
        postsDao.save(post);
        return "redirect:/posts";
    }
}


