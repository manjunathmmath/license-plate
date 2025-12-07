package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectGeconstateerd;

public interface VboBagObjectGeconstateerdRepository extends  JpaRepository<VboBagObjectGeconstateerd, Integer>{
    VboBagObjectGeconstateerd findByBagObject(String bagObject);
}
