package license.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.pnd.PndBagObjectVoorkomen;

public interface PndBagObjectVoorkomenRepository extends  JpaRepository<PndBagObjectVoorkomen, Integer>{
    PndBagObjectVoorkomen findByBagObject(String bagObject);
}
