package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObjectStatus;
import tradebot.domain.pnd.PndBagObjectStatus;
import tradebot.repository.num.NumBagObjectStatusRepository;
import tradebot.repository.pnd.PndBagObjectStatusRepository;

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
