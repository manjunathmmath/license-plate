package license.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObjectDocumentnummer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_documentnummer_seq")
    @SequenceGenerator(name = "num_bag_object_documentnummer_seq", sequenceName = "num_bag_object_documentnummer_seq")
    private Integer id;

    private String bagObject;

    private String documentnummer;

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

    public String getDocumentnummer() {
        return documentnummer;
    }

    public void setDocumentnummer(String documentnummer) {
        this.documentnummer = documentnummer;
    }
}
