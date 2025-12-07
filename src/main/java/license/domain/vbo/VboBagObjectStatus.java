package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_status_seq")
    @SequenceGenerator(name = "vbo_bag_object_status_seq", sequenceName = "vbo_bag_object_status_seq")
    private Integer id;

    private String bagObject;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
