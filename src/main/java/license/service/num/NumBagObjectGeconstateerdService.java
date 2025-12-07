package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectGeconstateerd;
import license.repository.num.NumBagObjectGeconstateerdRepository;

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
