package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectVoorkomen;
import license.repository.vbo.VboBagObjectVoorkomenRepository;

import java.util.List;


@Service
public class VboBagObjectVoorkomenService {

    @Autowired
    private VboBagObjectVoorkomenRepository vboBagObjectVoorkomenRepository;


    public VboBagObjectVoorkomen save(VboBagObjectVoorkomen vboBagObjectVoorkomen) {
        return this.vboBagObjectVoorkomenRepository.save(vboBagObjectVoorkomen);
    }

    public List<VboBagObjectVoorkomen> findAll() {
        return this.vboBagObjectVoorkomenRepository.findAll();
    }

    public VboBagObjectVoorkomen findByBagObject(String bagObject) {
        return this.vboBagObjectVoorkomenRepository.findByBagObject(bagObject);
    }

}
