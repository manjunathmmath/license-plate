package tradebot.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.pnd.PndBagObjectVoorkomen;
import tradebot.repository.pnd.PndBagObjectVoorkomenRepository;

import java.util.List;


@Service
public class PndBagObjectVoorkomenService {

    @Autowired
    private PndBagObjectVoorkomenRepository pndBagObjectVoorkomenRepository;


    public PndBagObjectVoorkomen save(PndBagObjectVoorkomen pndBagObjectVoorkomen) {
        return this.pndBagObjectVoorkomenRepository.save(pndBagObjectVoorkomen);
    }

    public List<PndBagObjectVoorkomen> findAll() {
        return this.pndBagObjectVoorkomenRepository.findAll();
    }

    public PndBagObjectVoorkomen findByBagObject(String bagObject) {
        return this.pndBagObjectVoorkomenRepository.findByBagObject(bagObject);
    }

}
