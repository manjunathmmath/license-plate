package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectGeometrie;

public interface VboBagObjectGeometrieRepository extends  JpaRepository<VboBagObjectGeometrie, Integer>{
    VboBagObjectGeometrie findByBagObject(String bagObject);
}
