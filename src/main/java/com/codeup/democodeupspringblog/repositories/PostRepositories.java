package com.codeup.democodeupspringblog.repositories;
import com.codeup.democodeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepositories extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
}