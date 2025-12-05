package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectGeconstateerd;
import tradebot.domain.pnd.PndBagObjectGeconstateerd;

public interface NumBagObjectGeconstateerdRepository extends  JpaRepository<NumBagObjectGeconstateerd, Integer>{
    NumBagObjectGeconstateerd findByBagObject(String bagObject);
}
