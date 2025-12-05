package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectLigtAan;
import tradebot.domain.num.NumBagObjectStatus;

public interface NumBagObjectLigtAanRepository extends  JpaRepository<NumBagObjectLigtAan, Integer>{
    NumBagObjectLigtAan findByBagObject(String bagObject);
}
