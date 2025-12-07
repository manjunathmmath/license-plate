package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectDocumentnummer;
import license.repository.vbo.VboBagObjectDocumentnummerRepository;

import java.util.List;


@Service
public class VboBagObjectDocumentnummerService {

    @Autowired
    private VboBagObjectDocumentnummerRepository vboBagObjectDocumentnummerRepository;


    public VboBagObjectDocumentnummer save(VboBagObjectDocumentnummer bagObjectDocumentnummer) {
        return this.vboBagObjectDocumentnummerRepository.save(bagObjectDocumentnummer);
    }

    public List<VboBagObjectDocumentnummer> findAll() {
        return this.vboBagObjectDocumentnummerRepository.findAll();
    }

    public VboBagObjectDocumentnummer findByBagObject(String bagObject) {
        return this.vboBagObjectDocumentnummerRepository.findByBagObject(bagObject);
    }

}
