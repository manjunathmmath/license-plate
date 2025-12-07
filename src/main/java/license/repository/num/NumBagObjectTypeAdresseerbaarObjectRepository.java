package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectTypeAdresseerbaarObject;

public interface NumBagObjectTypeAdresseerbaarObjectRepository extends  JpaRepository<NumBagObjectTypeAdresseerbaarObject, Integer>{
    NumBagObjectTypeAdresseerbaarObject findByBagObject(String bagObject);
}
