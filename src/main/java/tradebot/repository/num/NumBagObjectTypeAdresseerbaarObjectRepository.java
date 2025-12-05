package tradebot.repository.num;

import org.springframework.data.jpa.repository.JpaRepository;
import tradebot.domain.num.NumBagObjectStatus;
import tradebot.domain.num.NumBagObjectTypeAdresseerbaarObject;

public interface NumBagObjectTypeAdresseerbaarObjectRepository extends  JpaRepository<NumBagObjectTypeAdresseerbaarObject, Integer>{
    NumBagObjectTypeAdresseerbaarObject findByBagObject(String bagObject);
}
