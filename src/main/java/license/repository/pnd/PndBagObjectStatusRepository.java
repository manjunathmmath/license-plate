package license.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.pnd.PndBagObjectStatus;

public interface PndBagObjectStatusRepository extends  JpaRepository<PndBagObjectStatus, Integer>{
    PndBagObjectStatus findByBagObject(String bagObject);
}
