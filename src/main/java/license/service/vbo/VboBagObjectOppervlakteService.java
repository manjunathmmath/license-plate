package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectOppervlakte;
import license.repository.vbo.VboBagObjectOppervlakteRepository;

import java.util.List;


@Service
public class VboBagObjectOppervlakteService {

    @Autowired
    private VboBagObjectOppervlakteRepository vboBagObjectOppervlakteRepository;


    public VboBagObjectOppervlakte save(VboBagObjectOppervlakte vboBagObjectOppervlakte) {
        return this.vboBagObjectOppervlakteRepository.save(vboBagObjectOppervlakte);
    }

    public List<VboBagObjectOppervlakte> findAll() {
        return this.vboBagObjectOppervlakteRepository.findAll();
    }

    public VboBagObjectOppervlakte findByBagObject(String bagObject) {
        return this.vboBagObjectOppervlakteRepository.findByBagObject(bagObject);
    }

}
