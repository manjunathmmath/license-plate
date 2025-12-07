package license.domain.post;

import javax.persistence.*;

@Entity
public class PostImages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_images_seq")
    @SequenceGenerator(name = "post_images_seq", sequenceName = "post_images_seq")
    private Integer id;

    private String name;
    private String type;

    @Lob
    private byte[] imageData;

    private String postId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
