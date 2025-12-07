package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectStatus;

public interface VboBagObjectStatusRepository extends  JpaRepository<VboBagObjectStatus, Integer>{
    VboBagObjectStatus findByBagObject(String bagObject);
}
