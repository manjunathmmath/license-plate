package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectPostcode;

public interface NumBagObjectPostcodeRepository extends  JpaRepository<NumBagObjectPostcode, Integer>{
    NumBagObjectPostcode findByBagObject(String bagObject);
}
