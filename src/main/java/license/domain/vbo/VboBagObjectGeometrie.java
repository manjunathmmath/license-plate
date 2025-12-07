package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectGeometrie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_geometrie_seq")
    @SequenceGenerator(name = "vbo_bag_object_geometrie_seq", sequenceName = "vbo_bag_object_geometrie_seq")
    private Integer id;

    private String bagObject;

    @Column(columnDefinition = "varchar(4000)")
    private String postList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBagObject() {
        return bagObject;
    }

    public void setBagObject(String bagObject) {
        this.bagObject = bagObject;
    }

    public String getPostList() {
        return postList;
    }

    public void setPostList(String postList) {
        this.postList = postList;
    }
}
