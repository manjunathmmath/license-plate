package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectVoorkomen;
import license.repository.num.NumBagObjectVoorkomenRepository;

import java.util.List;


@Service
public class NumBagObjectVoorkomenService {

    @Autowired
    private NumBagObjectVoorkomenRepository numBagObjectVoorkomenRepository;


    public NumBagObjectVoorkomen save(NumBagObjectVoorkomen numBagObjectVoorkomen) {
        return this.numBagObjectVoorkomenRepository.save(numBagObjectVoorkomen);
    }

    public List<NumBagObjectVoorkomen> findAll() {
        return this.numBagObjectVoorkomenRepository.findAll();
    }

    public NumBagObjectVoorkomen findByBagObject(String bagObject) {
        return this.numBagObjectVoorkomenRepository.findByBagObject(bagObject);
    }

}
