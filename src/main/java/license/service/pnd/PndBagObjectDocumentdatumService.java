package license.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.pnd.PndBagObjectDocumentdatum;
import license.repository.pnd.PndBagObjectDocumentdatumRepository;

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
