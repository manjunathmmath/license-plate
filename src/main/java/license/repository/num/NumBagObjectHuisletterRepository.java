package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectHuisletter;

public interface NumBagObjectHuisletterRepository extends  JpaRepository<NumBagObjectHuisletter, Integer>{
    NumBagObjectHuisletter findByBagObject(String bagObject);
}
