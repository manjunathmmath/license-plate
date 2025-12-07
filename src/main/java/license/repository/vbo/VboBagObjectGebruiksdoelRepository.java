package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectGebruiksdoel;

public interface VboBagObjectGebruiksdoelRepository extends  JpaRepository<VboBagObjectGebruiksdoel, Integer>{
    VboBagObjectGebruiksdoel findByBagObject(String bagObject);
}
