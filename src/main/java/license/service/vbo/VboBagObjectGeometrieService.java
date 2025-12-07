package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectGeometrie;
import license.repository.vbo.VboBagObjectGeometrieRepository;

import java.util.List;


@Service
public class VboBagObjectGeometrieService {

    @Autowired
    private VboBagObjectGeometrieRepository vboBagObjectGeometrieRepository;


    public VboBagObjectGeometrie save(VboBagObjectGeometrie vboBagObjectGeometrie) {
        return this.vboBagObjectGeometrieRepository.save(vboBagObjectGeometrie);
    }

    public List<VboBagObjectGeometrie> findAll() {
        return this.vboBagObjectGeometrieRepository.findAll();
    }

    public VboBagObjectGeometrie findByBagObject(String bagObject) {
        return this.vboBagObjectGeometrieRepository.findByBagObject(bagObject);
    }

}
