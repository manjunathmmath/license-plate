package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectHuisletter;
import license.repository.num.NumBagObjectHuisletterRepository;

import java.util.List;


@Service
public class NumBagObjectHuisletterService {

    @Autowired
    private NumBagObjectHuisletterRepository numBagObjectHuisletterRepository;


    public NumBagObjectHuisletter save(NumBagObjectHuisletter numBagObjectHuisletter) {
        return this.numBagObjectHuisletterRepository.save(numBagObjectHuisletter);
    }

    public List<NumBagObjectHuisletter> findAll() {
        return this.numBagObjectHuisletterRepository.findAll();
    }

    public NumBagObjectHuisletter findByBagObject(String bagObject) {
        return this.numBagObjectHuisletterRepository.findByBagObject(bagObject);
    }

}
