package license.repository.vbo;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.vbo.VboBagObjectHeeftAlsHoofdadres;

public interface VboBagObjectHeeftAlsHoofdadresRepository extends  JpaRepository<VboBagObjectHeeftAlsHoofdadres, Integer>{
    VboBagObjectHeeftAlsHoofdadres findByBagObject(String bagObject);
}
