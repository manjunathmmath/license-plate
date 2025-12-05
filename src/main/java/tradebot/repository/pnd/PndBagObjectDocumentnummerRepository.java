package tradebot.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.pnd.PndBagObjectDocumentnummer;

public interface PndBagObjectDocumentnummerRepository extends  JpaRepository<PndBagObjectDocumentnummer, Integer>{
    PndBagObjectDocumentnummer findByBagObject(String bagObject);
}
