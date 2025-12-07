package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObject;
import license.repository.num.NumBagObjectRepository;

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
