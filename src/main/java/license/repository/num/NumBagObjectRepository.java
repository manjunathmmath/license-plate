package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObject;

public interface NumBagObjectRepository extends  JpaRepository<NumBagObject, Integer>{
    NumBagObject findByIdentificatie(String identificatie);
}
