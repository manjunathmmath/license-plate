package license.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.pnd.PndBagObjectDocumentnummer;
import license.repository.pnd.PndBagObjectDocumentnummerRepository;

import java.util.List;


@Service
public class PndBagObjectDocumentnummerService {

    @Autowired
    private PndBagObjectDocumentnummerRepository pndBagObjectDocumentnummerRepository;


    public PndBagObjectDocumentnummer save(PndBagObjectDocumentnummer bagObjectDocumentnummer) {
        return this.pndBagObjectDocumentnummerRepository.save(bagObjectDocumentnummer);
    }

    public List<PndBagObjectDocumentnummer> findAll() {
        return this.pndBagObjectDocumentnummerRepository.findAll();
    }

    public PndBagObjectDocumentnummer findByBagObject(String bagObject) {
        return this.pndBagObjectDocumentnummerRepository.findByBagObject(bagObject);
    }

}
