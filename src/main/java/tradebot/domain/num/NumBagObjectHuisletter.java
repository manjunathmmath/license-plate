package tradebot.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectHuisletter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_huisletter_seq")
    @SequenceGenerator(name = "num_bag_object_huisletter_seq", sequenceName = "num_bag_object_huisletter_seq")
    private Integer id;

    private String bagObject;

    private String huisletter;

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

    public String getHuisletter() {
        return huisletter;
    }

    public void setHuisletter(String huisletter) {
        this.huisletter = huisletter;
    }
}
