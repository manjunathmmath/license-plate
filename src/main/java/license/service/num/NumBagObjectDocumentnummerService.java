package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectDocumentnummer;
import license.repository.num.NumBagObjectDocumentnummerRepository;

import java.util.List;


@Service
public class NumBagObjectDocumentnummerService {

    @Autowired
    private NumBagObjectDocumentnummerRepository numBagObjectDocumentnummerRepository;


    public NumBagObjectDocumentnummer save(NumBagObjectDocumentnummer bagObjectDocumentnummer) {
        return this.numBagObjectDocumentnummerRepository.save(bagObjectDocumentnummer);
    }

    public List<NumBagObjectDocumentnummer> findAll() {
        return this.numBagObjectDocumentnummerRepository.findAll();
    }

    public NumBagObjectDocumentnummer findByBagObject(String bagObject) {
        return this.numBagObjectDocumentnummerRepository.findByBagObject(bagObject);
    }

}
