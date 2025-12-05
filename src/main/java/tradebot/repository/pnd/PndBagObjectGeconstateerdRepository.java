package tradebot.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.pnd.PndBagObjectGeconstateerd;

public interface PndBagObjectGeconstateerdRepository extends  JpaRepository<PndBagObjectGeconstateerd, Integer>{
    PndBagObjectGeconstateerd findByBagObject(String bagObject);
}
