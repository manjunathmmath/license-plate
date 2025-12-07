package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectHeeftAlsHoofdadres;
import license.repository.vbo.VboBagObjectHeeftAlsHoofdadresRepository;

import java.util.List;


@Service
public class VboBagObjectHeeftAlsHoofdadresService {

    @Autowired
    private VboBagObjectHeeftAlsHoofdadresRepository vboBagObjectHeeftAlsHoofdadresRepository;


    public VboBagObjectHeeftAlsHoofdadres save(VboBagObjectHeeftAlsHoofdadres vboBagObjectHeeftAlsHoofdadres) {
        return this.vboBagObjectHeeftAlsHoofdadresRepository.save(vboBagObjectHeeftAlsHoofdadres);
    }

    public List<VboBagObjectHeeftAlsHoofdadres> findAll() {
        return this.vboBagObjectHeeftAlsHoofdadresRepository.findAll();
    }

    public VboBagObjectHeeftAlsHoofdadres findByBagObject(String bagObject) {
        return this.vboBagObjectHeeftAlsHoofdadresRepository.findByBagObject(bagObject);
    }

}
