package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectDocumentnummer;

public interface VboBagObjectDocumentnummerRepository extends  JpaRepository<VboBagObjectDocumentnummer, Integer>{
    VboBagObjectDocumentnummer findByBagObject(String bagObject);
}
