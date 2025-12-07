package license.service.vbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.vbo.VboBagObject;
import license.repository.vbo.VboBagObjectRepository;

import java.util.List;


@Service
public class VboBagObjectService {
	
	@Autowired
	private VboBagObjectRepository vboBagObjectRepository;


	public VboBagObject save(VboBagObject vboBagObject) {
		return this.vboBagObjectRepository.save(vboBagObject);
	}

	public List<VboBagObject> findAll() {
		return this.vboBagObjectRepository.findAll();
	}

	public VboBagObject findByIdentificatie(String bagObject) {
		return this.vboBagObjectRepository.findByIdentificatie(bagObject);
	}


}
