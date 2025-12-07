package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectGebruiksdoel;
import license.repository.vbo.VboBagObjectGebruiksdoelRepository;

import java.util.List;


@Service
public class VboBagObjectGebruiksdoelService {

    @Autowired
    private VboBagObjectGebruiksdoelRepository vboBagObjectGebruiksdoelRepository;


    public VboBagObjectGebruiksdoel save(VboBagObjectGebruiksdoel vboBagObjectGebruiksdoel) {
        return this.vboBagObjectGebruiksdoelRepository.save(vboBagObjectGebruiksdoel);
    }

    public List<VboBagObjectGebruiksdoel> findAll() {
        return this.vboBagObjectGebruiksdoelRepository.findAll();
    }

    public VboBagObjectGebruiksdoel findByBagObject(String bagObject) {
        return this.vboBagObjectGebruiksdoelRepository.findByBagObject(bagObject);
    }

}
