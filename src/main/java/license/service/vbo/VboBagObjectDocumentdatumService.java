package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectDocumentdatum;
import license.repository.vbo.VboBagObjectDocumentdatumRepository;

import java.util.List;


@Service
public class VboBagObjectDocumentdatumService {

    @Autowired
    private VboBagObjectDocumentdatumRepository vboBagObjectDocumentdatumRepository;

    public VboBagObjectDocumentdatum save(VboBagObjectDocumentdatum vboBagObjectDocumentdatum) {
        return this.vboBagObjectDocumentdatumRepository.save(vboBagObjectDocumentdatum);
    }

    public List<VboBagObjectDocumentdatum> findAll() {
        return this.vboBagObjectDocumentdatumRepository.findAll();
    }

    public VboBagObjectDocumentdatum findByBagObject(String bagObject) {
        return this.vboBagObjectDocumentdatumRepository.findByBagObject(bagObject);
    }

}
