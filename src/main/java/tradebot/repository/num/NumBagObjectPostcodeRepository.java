package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectPostcode;
import tradebot.domain.num.NumBagObjectStatus;

public interface NumBagObjectPostcodeRepository extends  JpaRepository<NumBagObjectPostcode, Integer>{
    NumBagObjectPostcode findByBagObject(String bagObject);
}
