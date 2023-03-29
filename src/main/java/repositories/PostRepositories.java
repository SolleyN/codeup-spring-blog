package repositories;
import jakarta.persistence.*;
import models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepositories extends JpaRepository<Post, Long> {

}