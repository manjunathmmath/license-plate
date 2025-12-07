package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectDocumentdatum;

public interface VboBagObjectDocumentdatumRepository extends  JpaRepository<VboBagObjectDocumentdatum, Integer>{
    VboBagObjectDocumentdatum findByBagObject(String bagObject);
}
