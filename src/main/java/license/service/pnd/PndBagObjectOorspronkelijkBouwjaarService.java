package license.service.pnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.pnd.PndBagObjectOorspronkelijkBouwjaar;
import license.repository.pnd.PndBagObjectOorspronkelijkBouwjaarRepository;

import java.util.List;


@Service
public class PndBagObjectOorspronkelijkBouwjaarService {

    @Autowired
    private PndBagObjectOorspronkelijkBouwjaarRepository pndBagObjectOorspronkelijkBouwjaarRepository;


    public PndBagObjectOorspronkelijkBouwjaar save(PndBagObjectOorspronkelijkBouwjaar bagObjectOorspronkelijkBouwjaar) {
        return this.pndBagObjectOorspronkelijkBouwjaarRepository.save(bagObjectOorspronkelijkBouwjaar);
    }

    public List<PndBagObjectOorspronkelijkBouwjaar> findAll() {
        return this.pndBagObjectOorspronkelijkBouwjaarRepository.findAll();
    }

    public PndBagObjectOorspronkelijkBouwjaar findByBagObject(String bagObject) {
        return this.pndBagObjectOorspronkelijkBouwjaarRepository.findByBagObject(bagObject);
    }

}
