package bitlab.g111.springsecurity.repositories;

import bitlab.g111.springsecurity.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
