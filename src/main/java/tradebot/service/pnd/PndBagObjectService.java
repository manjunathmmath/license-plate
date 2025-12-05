package tradebot.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.pnd.PndBagObject;
import tradebot.repository.pnd.PndBagObjectRepository;

import java.util.List;


@Service
public class PndBagObjectService {
	
	@Autowired
	private PndBagObjectRepository pndBagObjectRepository;


	public PndBagObject save(PndBagObject pndBagObject) {
		return this.pndBagObjectRepository.save(pndBagObject);
	}

	public List<PndBagObject> findAll() {
		return this.pndBagObjectRepository.findAll();
	}

	public PndBagObject findByIdentificatie(String bagObject) {
		return this.pndBagObjectRepository.findByIdentificatie(bagObject);
	}


}
