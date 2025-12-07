package license.domain.pnd;

import javax.persistence.*;

@Entity
public class PndBagObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_bag_object_seq")
    @SequenceGenerator(name = "pnd_bag_object_seq", sequenceName = "pnd_bag_object_seq")
    private Integer id;

    private String folder;

    private String file;

    private String identificatie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificatie() {
        return identificatie;
    }

    public void setIdentificatie(String identificatie) {
        this.identificatie = identificatie;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
