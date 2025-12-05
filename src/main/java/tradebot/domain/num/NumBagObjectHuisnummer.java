package tradebot.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectHuisnummer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_huisnummer_seq")
    @SequenceGenerator(name = "num_bag_object_huisnummer_seq", sequenceName = "num_bag_object_huisnummer_seq")
    private Integer id;

    private String bagObject;

    private String huisnummer;

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

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }
}
