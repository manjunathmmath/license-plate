package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectDocumentdatum;
import license.repository.num.NumBagObjectDocumentdatumRepository;

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
