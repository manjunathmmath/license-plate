package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectDocumentdatum;
import tradebot.domain.pnd.PndBagObjectDocumentdatum;
import tradebot.repository.num.NumBagObjectDocumentdatumRepository;
import tradebot.repository.pnd.PndBagObjectDocumentdatumRepository;

import java.util.List;


@Service
public class NumBagObjectDocumentdatumService {

    @Autowired
    private NumBagObjectDocumentdatumRepository numBagObjectDocumentdatumRepository;

    public NumBagObjectDocumentdatum save(NumBagObjectDocumentdatum numBagObjectDocumentdatum) {
        return this.numBagObjectDocumentdatumRepository.save(numBagObjectDocumentdatum);
    }

    public List<NumBagObjectDocumentdatum> findAll() {
        return this.numBagObjectDocumentdatumRepository.findAll();
    }

    public NumBagObjectDocumentdatum findByBagObject(String bagObject) {
        return this.numBagObjectDocumentdatumRepository.findByBagObject(bagObject);
    }

}
