package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectDocumentdatum;
import tradebot.domain.pnd.PndBagObjectDocumentdatum;

public interface NumBagObjectDocumentdatumRepository extends  JpaRepository<NumBagObjectDocumentdatum, Integer>{
    NumBagObjectDocumentdatum findByBagObject(String bagObject);
}
