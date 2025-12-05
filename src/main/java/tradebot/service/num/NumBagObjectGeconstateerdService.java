package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectGeconstateerd;
import tradebot.domain.pnd.PndBagObjectGeconstateerd;
import tradebot.repository.num.NumBagObjectGeconstateerdRepository;
import tradebot.repository.pnd.PndBagObjectGeconstateerdRepository;

import java.util.List;


@Service
public class NumBagObjectGeconstateerdService {

    @Autowired
    private NumBagObjectGeconstateerdRepository numBagObjectGeconstateerdRepository;


    public NumBagObjectGeconstateerd save(NumBagObjectGeconstateerd numBagObjectGeconstateerd) {
        return this.numBagObjectGeconstateerdRepository.save(numBagObjectGeconstateerd);
    }

    public List<NumBagObjectGeconstateerd> findAll() {
        return this.numBagObjectGeconstateerdRepository.findAll();
    }

    public NumBagObjectGeconstateerd findByBagObject(String bagObject) {
        return this.numBagObjectGeconstateerdRepository.findByBagObject(bagObject);
    }

}
