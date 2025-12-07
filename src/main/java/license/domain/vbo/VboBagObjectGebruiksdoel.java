package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectGebruiksdoel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_gebruiksdoel_seq")
    @SequenceGenerator(name = "vbo_bag_object_gebruiksdoel_seq", sequenceName = "vbo_bag_object_gebruiksdoel_seq")
    private Integer id;

    private String bagObject;

    private String gebruiksdoel;

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

    public String getGebruiksdoel() {
        return gebruiksdoel;
    }

    public void setGebruiksdoel(String gebruiksdoel) {
        this.gebruiksdoel = gebruiksdoel;
    }
}
