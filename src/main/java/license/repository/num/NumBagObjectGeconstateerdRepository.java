package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectGeconstateerd;

public interface NumBagObjectGeconstateerdRepository extends  JpaRepository<NumBagObjectGeconstateerd, Integer>{
    NumBagObjectGeconstateerd findByBagObject(String bagObject);
}
