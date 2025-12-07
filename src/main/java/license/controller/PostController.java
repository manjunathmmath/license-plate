package license.controller;

import license.domain.post.Post;
import license.domain.post.PostImages;
import license.service.post.PostImageService;
import license.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostImageService postImageService;

    @PostMapping("/upload")
    @ResponseBody
    @Transactional
    public Map<String, String> upload(@RequestParam Map<String, String> reqParam, MultipartFile file) throws IOException {
        Map<String, String> data = new HashMap<>();
        String id = reqParam.get("postId");
        System.out.println(id);
        if(isNotEmpty(id)){
            PostImages postImages= new PostImages();
            postImages.setName(file.getOriginalFilename());
            postImages.setType(file.getContentType());
            postImages.setImageData(file.getBytes());
            postImages.setPostId(id);
            this.postImageService.save(postImages);
        }
        return data;
    }


    @PostMapping("/savePost")
    @ResponseBody
    @Transactional
    public Map<String, String> savePost(@RequestParam Map<String, String> reqParam) {
        String title = reqParam.get("title");
        String email = reqParam.get("email");
        String description = reqParam.get("description");
        Map<String, String> data = new HashMap<>();
        Post post = new Post();
        post.setTitle(title);
        post.setEmail(email);
        post.setDescription(description);
        if (this.postService.save(post) != null) {
            data.put("status", "success");
            data.put("id", post.getId().toString());
        } else {
            data.put("status", "failure");
        }
        return data;
    }

    @GetMapping(path = {"/getPosts"})
    @ResponseBody
    public List<Map<String, Object>> getPosts(Model model,
                                              @RequestParam Map<String, String> reqParam) throws Exception {
        List<Map<String, Object>> dataList = new ArrayList<>();
        List<Post> notesList = this.postService.findAll();
        Iterator<Post> iteratorObject = notesList.iterator();
        while (iteratorObject.hasNext()) {
            Post record = iteratorObject.next();
            Map<String, Object> data = new HashMap<>();
            data.put("id", record.getId().toString());
            data.put("title", record.getTitle());
            data.put("email", record.getEmail());
            data.put("description", record.getDescription());
            List<PostImages>  images = this.postImageService.findAllByPostId(record.getId().toString());
            data.put("images",images);
            dataList.add(data);
        }
        return dataList;
    }

}
