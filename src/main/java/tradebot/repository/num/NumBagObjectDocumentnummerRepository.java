package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectDocumentnummer;
import tradebot.domain.pnd.PndBagObjectDocumentnummer;

public interface NumBagObjectDocumentnummerRepository extends  JpaRepository<NumBagObjectDocumentnummer, Integer>{
    NumBagObjectDocumentnummer findByBagObject(String bagObject);
}
