package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObjectStatus;
import license.repository.vbo.VboBagObjectStatusRepository;

import java.util.List;


@Service
public class VboBagObjectStatusService {

    @Autowired
    private VboBagObjectStatusRepository vboBagObjectStatusRepository;


    public VboBagObjectStatus save(VboBagObjectStatus vboBagObjectStatus) {
        return this.vboBagObjectStatusRepository.save(vboBagObjectStatus);
    }

    public List<VboBagObjectStatus> findAll() {
        return this.vboBagObjectStatusRepository.findAll();
    }

    public VboBagObjectStatus findByBagObject(String bagObject) {
        return this.vboBagObjectStatusRepository.findByBagObject(bagObject);
    }

}
