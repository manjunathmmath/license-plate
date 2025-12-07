package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectOppervlakte;

public interface VboBagObjectOppervlakteRepository extends  JpaRepository<VboBagObjectOppervlakte, Integer>{
    VboBagObjectOppervlakte findByBagObject(String bagObject);
}
