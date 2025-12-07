package license.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectPostcode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_postcode_seq")
    @SequenceGenerator(name = "num_bag_object_postcode_seq", sequenceName = "num_bag_object_postcode_seq")
    private Integer id;

    private String bagObject;

    private String postcode;

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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
