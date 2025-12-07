package license.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.pnd.PndBagObjectGeconstateerd;

public interface PndBagObjectGeconstateerdRepository extends  JpaRepository<PndBagObjectGeconstateerd, Integer>{
    PndBagObjectGeconstateerd findByBagObject(String bagObject);
}
