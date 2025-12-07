package license.service.post;

import license.domain.CustomConfiguration;
import license.domain.post.Post;
import license.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public Post findByConfigKey(Integer id) {
		return this.postRepository.findById(id).orElse(null);
	}

	public Post save(Post post) {
		return this.postRepository.save(post);
	}

	public List<Post> findAllByEmail(String email) {
		return this.postRepository.findAllByEmail(email);
	}

	public List<Post> findAll() {
		return this.postRepository.findAll();
	}

}
