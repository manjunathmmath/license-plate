package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectStatus;
import tradebot.domain.pnd.PndBagObjectStatus;

public interface NumBagObjectStatusRepository extends  JpaRepository<NumBagObjectStatus, Integer>{
    NumBagObjectStatus findByBagObject(String bagObject);
}
