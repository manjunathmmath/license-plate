package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectOppervlakte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_oppervlakte_seq")
    @SequenceGenerator(name = "vbo_bag_object_oppervlakte_seq", sequenceName = "vbo_bag_object_oppervlakte_seq")
    private Integer id;

    private String bagObject;

    private String oppervlakte;

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

    public String getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(String oppervlakte) {
        this.oppervlakte = oppervlakte;
    }
}
