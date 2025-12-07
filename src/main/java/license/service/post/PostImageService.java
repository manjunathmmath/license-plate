package license.service.post;

import license.domain.post.Post;
import license.domain.post.PostImages;
import license.repository.post.PostImageRepository;
import license.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostImageService {
	
	@Autowired
	private PostImageRepository postImageRepository;

	public PostImages findById(Integer id) {
		return this.postImageRepository.findById(id).orElse(null);
	}

	public PostImages save(PostImages postImages) {
		return this.postImageRepository.save(postImages);
	}

	public List<PostImages> findAllByPostId(String postId) {
		return this.postImageRepository.findAllByPostId(postId);
	}

	public List<PostImages> findAll() {
		return this.postImageRepository.findAll();
	}

}
