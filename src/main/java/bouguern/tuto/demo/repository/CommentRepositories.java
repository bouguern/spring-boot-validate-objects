package bouguern.tuto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouguern.tuto.demo.models.Comment;

@Repository
public interface CommentRepositories extends JpaRepository<Comment, Long> {

}
