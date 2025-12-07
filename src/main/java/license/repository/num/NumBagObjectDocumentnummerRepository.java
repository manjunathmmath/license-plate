package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectDocumentnummer;

public interface NumBagObjectDocumentnummerRepository extends  JpaRepository<NumBagObjectDocumentnummer, Integer>{
    NumBagObjectDocumentnummer findByBagObject(String bagObject);
}
