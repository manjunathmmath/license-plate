package license.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectTypeAdresseerbaarObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_typeAdresseerbaarObject_seq")
    @SequenceGenerator(name = "num_bag_object_typeAdresseerbaarObject_seq", sequenceName = "num_bag_object_typeAdresseerbaarObject_seq")
    private Integer id;

    private String bagObject;

    private String typeAdresseerbaarObject;

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

    public String getTypeAdresseerbaarObject() {
        return typeAdresseerbaarObject;
    }

    public void setTypeAdresseerbaarObject(String typeAdresseerbaarObject) {
        this.typeAdresseerbaarObject = typeAdresseerbaarObject;
    }
}
