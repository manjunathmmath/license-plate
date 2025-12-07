package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectGeconstateerd;
import license.repository.vbo.VboBagObjectGeconstateerdRepository;

import java.util.List;


@Service
public class VboBagObjectGeconstateerdService {

    @Autowired
    private VboBagObjectGeconstateerdRepository vboBagObjectGeconstateerdRepository;


    public VboBagObjectGeconstateerd save(VboBagObjectGeconstateerd vboBagObjectGeconstateerd) {
        return this.vboBagObjectGeconstateerdRepository.save(vboBagObjectGeconstateerd);
    }

    public List<VboBagObjectGeconstateerd> findAll() {
        return this.vboBagObjectGeconstateerdRepository.findAll();
    }

    public VboBagObjectGeconstateerd findByBagObject(String bagObject) {
        return this.vboBagObjectGeconstateerdRepository.findByBagObject(bagObject);
    }

}
