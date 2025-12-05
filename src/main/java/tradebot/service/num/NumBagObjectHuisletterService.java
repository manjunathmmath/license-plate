package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectHuisletter;
import tradebot.domain.num.NumBagObjectHuisnummer;
import tradebot.repository.num.NumBagObjectHuisletterRepository;
import tradebot.repository.num.NumBagObjectHuisnummerRepository;

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
