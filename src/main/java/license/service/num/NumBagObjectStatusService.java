package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectStatus;
import license.repository.num.NumBagObjectStatusRepository;

import java.util.List;


@Service
public class NumBagObjectStatusService {

    @Autowired
    private NumBagObjectStatusRepository numBagObjectStatusRepository;


    public NumBagObjectStatus save(NumBagObjectStatus numBagObjectStatus) {
        return this.numBagObjectStatusRepository.save(numBagObjectStatus);
    }

    public List<NumBagObjectStatus> findAll() {
        return this.numBagObjectStatusRepository.findAll();
    }

    public NumBagObjectStatus findByBagObject(String bagObject) {
        return this.numBagObjectStatusRepository.findByBagObject(bagObject);
    }

}
