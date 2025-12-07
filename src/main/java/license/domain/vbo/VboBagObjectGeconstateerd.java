package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectGeconstateerd {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_geconstateerd_seq")
    @SequenceGenerator(name = "vbo_bag_object_geconstateerd_seq", sequenceName = "vbo_bag_object_geconstateerd_seq")
    private Integer id;

    private String bagObject;

    private String geconstateerd;

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

    public String getGeconstateerd() {
        return geconstateerd;
    }

    public void setGeconstateerd(String geconstateerd) {
        this.geconstateerd = geconstateerd;
    }
}
