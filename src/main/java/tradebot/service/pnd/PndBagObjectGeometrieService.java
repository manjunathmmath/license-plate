package tradebot.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.pnd.PndBagObjectGeometrie;
import tradebot.repository.pnd.PndBagObjectGeometrieRepository;

import java.util.List;


@Service
public class PndBagObjectGeometrieService {

    @Autowired
    private PndBagObjectGeometrieRepository pndBagObjectGeometrieRepository;


    public PndBagObjectGeometrie save(PndBagObjectGeometrie pndBagObjectGeometrie) {
        return this.pndBagObjectGeometrieRepository.save(pndBagObjectGeometrie);
    }

    public List<PndBagObjectGeometrie> findAll() {
        return this.pndBagObjectGeometrieRepository.findAll();
    }

    public PndBagObjectGeometrie findByBagObject(String bagObject) {
        return this.pndBagObjectGeometrieRepository.findByBagObject(bagObject);
    }

}
