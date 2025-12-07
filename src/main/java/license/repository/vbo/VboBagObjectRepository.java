package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObject;

public interface VboBagObjectRepository extends  JpaRepository<VboBagObject, Integer>{
    VboBagObject findByIdentificatie(String identificatie);
}
