package license.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectLigtAan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_ligtAan_seq")
    @SequenceGenerator(name = "num_bag_object_ligtAan_seq", sequenceName = "num_bag_object_ligtAan_seq")
    private Integer id;

    private String bagObject;

    private String ligtAan;

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

    public String getLigtAan() {
        return ligtAan;
    }

    public void setLigtAan(String ligtAan) {
        this.ligtAan = ligtAan;
    }
}
