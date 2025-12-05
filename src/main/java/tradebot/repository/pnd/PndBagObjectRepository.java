package tradebot.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.pnd.PndBagObject;

public interface PndBagObjectRepository extends  JpaRepository<PndBagObject, Integer>{
    PndBagObject findByIdentificatie(String identificatie);
}
