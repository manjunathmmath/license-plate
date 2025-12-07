package license.domain.pnd;

import javax.persistence.*;

@Entity
public class PndBagObjectDocumentdatum {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_bag_object_documentdatum_seq")
    @SequenceGenerator(name = "pnd_bag_object_documentdatum_seq", sequenceName = "pnd_bag_object_documentdatum_seq")
    private Integer id;

    private String bagObject;

    private String documentdatum;

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

    public String getDocumentdatum() {
        return documentdatum;
    }

    public void setDocumentdatum(String documentdatum) {
        this.documentdatum = documentdatum;
    }
}
