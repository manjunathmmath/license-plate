package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectVoorkomen;
import tradebot.domain.pnd.PndBagObjectVoorkomen;
import tradebot.repository.num.NumBagObjectVoorkomenRepository;
import tradebot.repository.pnd.PndBagObjectVoorkomenRepository;

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
