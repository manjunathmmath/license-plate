package license.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.pnd.PndBagObject;

public interface PndBagObjectRepository extends  JpaRepository<PndBagObject, Integer>{
    PndBagObject findByIdentificatie(String identificatie);
}
