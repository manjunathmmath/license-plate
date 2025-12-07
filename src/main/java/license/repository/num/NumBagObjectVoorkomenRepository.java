package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectVoorkomen;

public interface NumBagObjectVoorkomenRepository extends  JpaRepository<NumBagObjectVoorkomen, Integer>{
    NumBagObjectVoorkomen findByBagObject(String bagObject);
}
