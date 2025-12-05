package tradebot.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.pnd.PndBagObjectStatus;
import tradebot.repository.pnd.PndBagObjectStatusRepository;

import java.util.List;


@Service
public class PndBagObjectStatusService {

    @Autowired
    private PndBagObjectStatusRepository pndBagObjectStatusRepository;


    public PndBagObjectStatus save(PndBagObjectStatus pndBagObjectStatus) {
        return this.pndBagObjectStatusRepository.save(pndBagObjectStatus);
    }

    public List<PndBagObjectStatus> findAll() {
        return this.pndBagObjectStatusRepository.findAll();
    }

    public PndBagObjectStatus findByBagObject(String bagObject) {
        return this.pndBagObjectStatusRepository.findByBagObject(bagObject);
    }

}
