package tradebot.domain.pnd;

import javax.persistence.*;

@Entity
public class PndBagObjectGeconstateerd {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_bag_object_geconstateerd_seq")
    @SequenceGenerator(name = "pnd_bag_object_geconstateerd_seq", sequenceName = "pnd_bag_object_geconstateerd_seq")
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
