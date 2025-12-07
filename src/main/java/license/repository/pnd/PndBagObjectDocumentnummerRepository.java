package license.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.pnd.PndBagObjectDocumentnummer;

public interface PndBagObjectDocumentnummerRepository extends  JpaRepository<PndBagObjectDocumentnummer, Integer>{
    PndBagObjectDocumentnummer findByBagObject(String bagObject);
}
