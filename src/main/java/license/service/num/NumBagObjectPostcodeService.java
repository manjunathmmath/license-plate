package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectPostcode;
import license.repository.num.NumBagObjectPostcodeRepository;

import java.util.List;


@Service
public class NumBagObjectPostcodeService {

    @Autowired
    private NumBagObjectPostcodeRepository numBagObjectPostcodeRepository;


    public NumBagObjectPostcode save(NumBagObjectPostcode numBagObjectPostcode) {
        return this.numBagObjectPostcodeRepository.save(numBagObjectPostcode);
    }

    public List<NumBagObjectPostcode> findAll() {
        return this.numBagObjectPostcodeRepository.findAll();
    }

    public NumBagObjectPostcode findByBagObject(String bagObject) {
        return this.numBagObjectPostcodeRepository.findByBagObject(bagObject);
    }

}
