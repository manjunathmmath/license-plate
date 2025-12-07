package license.domain.pnd;

import javax.persistence.*;

@Entity
public class PndBagObjectOorspronkelijkBouwjaar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_bag_object_OorspronkelijkBouwjaar_seq")
    @SequenceGenerator(name = "pnd_bag_object_OorspronkelijkBouwjaar_seq", sequenceName = "pnd_bag_object_OorspronkelijkBouwjaar_seq")
    private Integer id;

    private String bagObject;

    private String oorspronkelijkBouwjaar;

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

    public String getOorspronkelijkBouwjaar() {
        return oorspronkelijkBouwjaar;
    }

    public void setOorspronkelijkBouwjaar(String oorspronkelijkBouwjaar) {
        this.oorspronkelijkBouwjaar = oorspronkelijkBouwjaar;
    }
}
