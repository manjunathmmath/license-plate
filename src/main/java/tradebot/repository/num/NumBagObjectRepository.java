package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObject;
import tradebot.domain.pnd.PndBagObject;

public interface NumBagObjectRepository extends  JpaRepository<NumBagObject, Integer>{
    NumBagObject findByIdentificatie(String identificatie);
}
