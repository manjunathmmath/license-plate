package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectStatus;

public interface NumBagObjectStatusRepository extends  JpaRepository<NumBagObjectStatus, Integer>{
    NumBagObjectStatus findByBagObject(String bagObject);
}
