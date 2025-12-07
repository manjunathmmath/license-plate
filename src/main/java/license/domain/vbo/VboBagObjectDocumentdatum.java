package license.domain.vbo;

import javax.persistence.*;

@Entity
public class VboBagObjectDocumentdatum {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vbo_bag_object_documentdatum_seq")
    @SequenceGenerator(name = "vbo_bag_object_documentdatum_seq", sequenceName = "vbo_bag_object_documentdatum_seq")
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
