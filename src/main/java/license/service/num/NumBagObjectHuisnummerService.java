package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectHuisnummer;
import license.repository.num.NumBagObjectHuisnummerRepository;

import java.util.List;


@Service
public class NumBagObjectHuisnummerService {

    @Autowired
    private NumBagObjectHuisnummerRepository numBagObjectHuisnummerRepository;


    public NumBagObjectHuisnummer save(NumBagObjectHuisnummer numBagObjectHuisnummer) {
        return this.numBagObjectHuisnummerRepository.save(numBagObjectHuisnummer);
    }

    public List<NumBagObjectHuisnummer> findAll() {
        return this.numBagObjectHuisnummerRepository.findAll();
    }

    public NumBagObjectHuisnummer findByBagObject(String bagObject) {
        return this.numBagObjectHuisnummerRepository.findByBagObject(bagObject);
    }

}
