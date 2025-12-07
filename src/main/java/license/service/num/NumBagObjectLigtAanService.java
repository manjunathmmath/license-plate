package license.service.num;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import license.domain.num.NumBagObjectLigtAan;
import license.repository.num.NumBagObjectLigtAanRepository;

import java.util.List;


@Service
public class NumBagObjectLigtAanService {

    @Autowired
    private NumBagObjectLigtAanRepository numBagObjectLigtAanRepository;


    public NumBagObjectLigtAan save(NumBagObjectLigtAan numBagObjectLigtAan) {
        return this.numBagObjectLigtAanRepository.save(numBagObjectLigtAan);
    }

    public List<NumBagObjectLigtAan> findAll() {
        return this.numBagObjectLigtAanRepository.findAll();
    }

    public NumBagObjectLigtAan findByBagObject(String bagObject) {
        return this.numBagObjectLigtAanRepository.findByBagObject(bagObject);
    }

}
