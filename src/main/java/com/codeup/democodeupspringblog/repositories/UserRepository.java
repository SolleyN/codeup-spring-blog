package com.codeup.democodeupspringblog.repositories;

import com.codeup.democodeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Controller
    public class UserController {
        private UserRepository users;

        public UserController(UserRepository users) {
            this.users = users;

        }

        @GetMapping("/sign-up")
        public String showSignupForm(Model model) {
            model.addAttribute("user", new User());
            return "users/sign-up";
        }

        @PostMapping("/sign-up")
        public String saveUser(@ModelAttribute User user) {
            users.save(user);
            return "redirect:/login";
        }
    }
}

