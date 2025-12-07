package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectMaaktDeelUitVan;

public interface VboBagObjectMaaktDeelUitVanRepository extends  JpaRepository<VboBagObjectMaaktDeelUitVan, Integer>{
    VboBagObjectMaaktDeelUitVan findByBagObject(String bagObject);
}
