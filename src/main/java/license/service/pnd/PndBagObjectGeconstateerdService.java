package license.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.pnd.PndBagObjectGeconstateerd;
import license.repository.pnd.PndBagObjectGeconstateerdRepository;

import java.util.List;


@Service
public class PndBagObjectGeconstateerdService {

    @Autowired
    private PndBagObjectGeconstateerdRepository pndBagObjectGeconstateerdRepository;


    public PndBagObjectGeconstateerd save(PndBagObjectGeconstateerd pndBagObjectGeconstateerd) {
        return this.pndBagObjectGeconstateerdRepository.save(pndBagObjectGeconstateerd);
    }

    public List<PndBagObjectGeconstateerd> findAll() {
        return this.pndBagObjectGeconstateerdRepository.findAll();
    }

    public PndBagObjectGeconstateerd findByBagObject(String bagObject) {
        return this.pndBagObjectGeconstateerdRepository.findByBagObject(bagObject);
    }

}
