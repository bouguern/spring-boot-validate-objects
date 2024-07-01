package bouguern.tuto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouguern.tuto.demo.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
