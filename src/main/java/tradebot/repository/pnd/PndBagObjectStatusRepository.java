package tradebot.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.pnd.PndBagObjectStatus;

public interface PndBagObjectStatusRepository extends  JpaRepository<PndBagObjectStatus, Integer>{
    PndBagObjectStatus findByBagObject(String bagObject);
}
