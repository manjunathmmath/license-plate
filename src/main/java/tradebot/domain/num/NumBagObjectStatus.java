package tradebot.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_status_seq")
    @SequenceGenerator(name = "num_bag_object_status_seq", sequenceName = "num_bag_object_status_seq")
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
