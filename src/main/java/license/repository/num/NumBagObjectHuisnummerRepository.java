package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectHuisnummer;

public interface NumBagObjectHuisnummerRepository extends  JpaRepository<NumBagObjectHuisnummer, Integer>{
    NumBagObjectHuisnummer findByBagObject(String bagObject);
}
