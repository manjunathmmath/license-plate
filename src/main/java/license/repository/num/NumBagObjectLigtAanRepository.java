package license.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import license.domain.num.NumBagObjectLigtAan;

public interface NumBagObjectLigtAanRepository extends  JpaRepository<NumBagObjectLigtAan, Integer>{
    NumBagObjectLigtAan findByBagObject(String bagObject);
}
