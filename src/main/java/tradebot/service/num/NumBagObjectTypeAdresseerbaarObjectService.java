package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectStatus;
import tradebot.domain.num.NumBagObjectTypeAdresseerbaarObject;
import tradebot.repository.num.NumBagObjectStatusRepository;
import tradebot.repository.num.NumBagObjectTypeAdresseerbaarObjectRepository;

import java.util.List;


@Service
public class NumBagObjectTypeAdresseerbaarObjectService {

    @Autowired
    private NumBagObjectTypeAdresseerbaarObjectRepository numBagObjectTypeAdresseerbaarObjectRepository;


    public NumBagObjectTypeAdresseerbaarObject save(NumBagObjectTypeAdresseerbaarObject numBagObjectTypeAdresseerbaarObject) {
        return this.numBagObjectTypeAdresseerbaarObjectRepository.save(numBagObjectTypeAdresseerbaarObject);
    }

    public List<NumBagObjectTypeAdresseerbaarObject> findAll() {
        return this.numBagObjectTypeAdresseerbaarObjectRepository.findAll();
    }

    public NumBagObjectTypeAdresseerbaarObject findByBagObject(String bagObject) {
        return this.numBagObjectTypeAdresseerbaarObjectRepository.findByBagObject(bagObject);
    }

}
