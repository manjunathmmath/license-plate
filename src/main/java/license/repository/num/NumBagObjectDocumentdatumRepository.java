package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectDocumentdatum;

public interface NumBagObjectDocumentdatumRepository extends  JpaRepository<NumBagObjectDocumentdatum, Integer>{
    NumBagObjectDocumentdatum findByBagObject(String bagObject);
}
