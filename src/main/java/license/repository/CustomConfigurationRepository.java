package license.repository;

import license.domain.CustomConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CustomConfigurationRepository extends  JpaRepository<CustomConfiguration, Integer>{
	CustomConfiguration findByConfigKey(String configKey);
	List<CustomConfiguration> findAllByConfigKeyIn(List<String> configKey);
}
