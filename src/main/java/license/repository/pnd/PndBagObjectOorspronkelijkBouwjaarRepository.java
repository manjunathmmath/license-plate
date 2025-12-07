package license.repository.pnd;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.pnd.PndBagObjectOorspronkelijkBouwjaar;

public interface PndBagObjectOorspronkelijkBouwjaarRepository extends  JpaRepository<PndBagObjectOorspronkelijkBouwjaar, Integer>{
    PndBagObjectOorspronkelijkBouwjaar findByBagObject(String bagObject);
}
