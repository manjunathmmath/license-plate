package tradebot.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.pnd.PndBagObjectDocumentdatum;

public interface PndBagObjectDocumentdatumRepository extends  JpaRepository<PndBagObjectDocumentdatum, Integer>{
    PndBagObjectDocumentdatum findByBagObject(String bagObject);
}
