package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectTypeAdresseerbaarObject;
import license.repository.num.NumBagObjectTypeAdresseerbaarObjectRepository;

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
