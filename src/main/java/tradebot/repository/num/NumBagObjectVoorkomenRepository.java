package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectVoorkomen;
import tradebot.domain.pnd.PndBagObjectVoorkomen;

public interface NumBagObjectVoorkomenRepository extends  JpaRepository<NumBagObjectVoorkomen, Integer>{
    NumBagObjectVoorkomen findByBagObject(String bagObject);
}
