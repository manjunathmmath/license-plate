package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectDocumentnummer;
import tradebot.repository.num.NumBagObjectDocumentnummerRepository;

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
