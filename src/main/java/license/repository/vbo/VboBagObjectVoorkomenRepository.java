package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectVoorkomen;

public interface VboBagObjectVoorkomenRepository extends  JpaRepository<VboBagObjectVoorkomen, Integer>{
    VboBagObjectVoorkomen findByBagObject(String bagObject);
}
