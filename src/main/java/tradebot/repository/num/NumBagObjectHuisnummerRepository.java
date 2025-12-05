package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectHuisnummer;
import tradebot.domain.num.NumBagObjectStatus;

public interface NumBagObjectHuisnummerRepository extends  JpaRepository<NumBagObjectHuisnummer, Integer>{
    NumBagObjectHuisnummer findByBagObject(String bagObject);
}
