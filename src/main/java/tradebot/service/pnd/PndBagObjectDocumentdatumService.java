package tradebot.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.pnd.PndBagObjectDocumentdatum;
import tradebot.repository.pnd.PndBagObjectDocumentdatumRepository;

import java.util.List;


@Service
public class PndBagObjectDocumentdatumService {

    @Autowired
    private PndBagObjectDocumentdatumRepository pndBagObjectDocumentdatumRepository;

    public PndBagObjectDocumentdatum save(PndBagObjectDocumentdatum pndBagObjectDocumentdatum) {
        return this.pndBagObjectDocumentdatumRepository.save(pndBagObjectDocumentdatum);
    }

    public List<PndBagObjectDocumentdatum> findAll() {
        return this.pndBagObjectDocumentdatumRepository.findAll();
    }

    public PndBagObjectDocumentdatum findByBagObject(String bagObject) {
        return this.pndBagObjectDocumentdatumRepository.findByBagObject(bagObject);
    }

}
