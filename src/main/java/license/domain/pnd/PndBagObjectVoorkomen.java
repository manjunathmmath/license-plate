package license.domain.pnd;

import javax.persistence.*;

@Entity
public class PndBagObjectVoorkomen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_bag_object_voorkomen_seq")
    @SequenceGenerator(name = "pnd_bag_object_voorkomen_seq", sequenceName = "pnd_bag_object_voorkomen_seq")
    private Integer id;

    private String bagObject;

    private String voorkomenidentificatie;

    private String beginGeldigheid;

    private String tijdstipRegistratie;

    private String tijdstipRegistratieLV;

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

    public String getVoorkomenidentificatie() {
        return voorkomenidentificatie;
    }

    public void setVoorkomenidentificatie(String voorkomenidentificatie) {
        this.voorkomenidentificatie = voorkomenidentificatie;
    }

    public String getBeginGeldigheid() {
        return beginGeldigheid;
    }

    public void setBeginGeldigheid(String beginGeldigheid) {
        this.beginGeldigheid = beginGeldigheid;
    }

    public String getTijdstipRegistratie() {
        return tijdstipRegistratie;
    }

    public void setTijdstipRegistratie(String tijdstipRegistratie) {
        this.tijdstipRegistratie = tijdstipRegistratie;
    }

    public String getTijdstipRegistratieLV() {
        return tijdstipRegistratieLV;
    }

    public void setTijdstipRegistratieLV(String tijdstipRegistratieLV) {
        this.tijdstipRegistratieLV = tijdstipRegistratieLV;
    }
}
