package license.repository.post;

import license.domain.post.Post;
import license.domain.post.PostImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostImageRepository extends  JpaRepository<PostImages, Integer>{
	List<PostImages> findAllByPostId(String postId);
}
