package license.domain.num;

import javax.persistence.*;

@Entity
public class NumBagObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_bag_object_seq")
    @SequenceGenerator(name = "num_bag_object_seq", sequenceName = "num_bag_object_seq")
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
