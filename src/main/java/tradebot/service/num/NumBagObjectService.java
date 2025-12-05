package tradebot.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradebot.domain.num.NumBagObject;
import tradebot.domain.pnd.PndBagObject;
import tradebot.repository.num.NumBagObjectRepository;
import tradebot.repository.pnd.PndBagObjectRepository;

import java.util.List;


@Service
public class NumBagObjectService {
	
	@Autowired
	private NumBagObjectRepository numBagObjectRepository;


	public NumBagObject save(NumBagObject numBagObject) {
		return this.numBagObjectRepository.save(numBagObject);
	}

	public List<NumBagObject> findAll() {
		return this.numBagObjectRepository.findAll();
	}

	public NumBagObject findByIdentificatie(String bagObject) {
		return this.numBagObjectRepository.findByIdentificatie(bagObject);
	}


}
