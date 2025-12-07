package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectMaaktDeelUitVan;
import license.repository.vbo.VboBagObjectMaaktDeelUitVanRepository;

import java.util.List;


@Service
public class VboBagObjectMaaktDeelUitVanService {

    @Autowired
    private VboBagObjectMaaktDeelUitVanRepository vboBagObjectMaaktDeelUitVanRepository;


    public VboBagObjectMaaktDeelUitVan save(VboBagObjectMaaktDeelUitVan vboBagObjectMaaktDeelUitVan) {
        return this.vboBagObjectMaaktDeelUitVanRepository.save(vboBagObjectMaaktDeelUitVan);
    }

    public List<VboBagObjectMaaktDeelUitVan> findAll() {
        return this.vboBagObjectMaaktDeelUitVanRepository.findAll();
    }

    public VboBagObjectMaaktDeelUitVan findByBagObject(String bagObject) {
        return this.vboBagObjectMaaktDeelUitVanRepository.findByBagObject(bagObject);
    }

}
