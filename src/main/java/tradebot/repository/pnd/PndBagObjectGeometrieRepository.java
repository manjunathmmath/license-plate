package tradebot.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.pnd.PndBagObjectGeometrie;

public interface PndBagObjectGeometrieRepository extends  JpaRepository<PndBagObjectGeometrie, Integer>{
    PndBagObjectGeometrie findByBagObject(String bagObject);
}
