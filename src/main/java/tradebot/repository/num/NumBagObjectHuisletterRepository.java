package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectHuisletter;
import tradebot.domain.num.NumBagObjectHuisnummer;

public interface NumBagObjectHuisletterRepository extends  JpaRepository<NumBagObjectHuisletter, Integer>{
    NumBagObjectHuisletter findByBagObject(String bagObject);
}
