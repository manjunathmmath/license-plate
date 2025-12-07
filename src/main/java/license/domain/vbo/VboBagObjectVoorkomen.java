package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectVoorkomen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_voorkomen_seq")
    @SequenceGenerator(name = "vbo_bag_object_voorkomen_seq", sequenceName = "vbo_bag_object_voorkomen_seq")
    private Integer id;

    private String bagObject;

    private String voorkomenidentificatie;

    private String beginGeldigheid;

    private String eindGeldigheid;

    private String tijdstipRegistratie;

    private String eindRegistratie;

    private String tijdstipRegistratieLV;

    private String tijdstipEindRegistratieLV;

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

    public String getEindGeldigheid() {
        return eindGeldigheid;
    }

    public void setEindGeldigheid(String eindGeldigheid) {
        this.eindGeldigheid = eindGeldigheid;
    }

    public String getTijdstipRegistratie() {
        return tijdstipRegistratie;
    }

    public void setTijdstipRegistratie(String tijdstipRegistratie) {
        this.tijdstipRegistratie = tijdstipRegistratie;
    }

    public String getEindRegistratie() {
        return eindRegistratie;
    }

    public void setEindRegistratie(String eindRegistratie) {
        this.eindRegistratie = eindRegistratie;
    }

    public String getTijdstipRegistratieLV() {
        return tijdstipRegistratieLV;
    }

    public void setTijdstipRegistratieLV(String tijdstipRegistratieLV) {
        this.tijdstipRegistratieLV = tijdstipRegistratieLV;
    }

    public String getTijdstipEindRegistratieLV() {
        return tijdstipEindRegistratieLV;
    }

    public void setTijdstipEindRegistratieLV(String tijdstipEindRegistratieLV) {
        this.tijdstipEindRegistratieLV = tijdstipEindRegistratieLV;
    }
}
