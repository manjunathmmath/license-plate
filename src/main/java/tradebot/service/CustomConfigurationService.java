package tradebot.service;

import tradebot.domain.CustomConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomConfigurationService {
	
	@Autowired
	private tradebot.repository.CustomConfigurationRepository customConfigurationRepository;

	public CustomConfiguration findByConfigKey(String configKey) {
		return this.customConfigurationRepository.findByConfigKey(configKey);
	}

	public CustomConfiguration save(CustomConfiguration customConfiguration) {
		return this.customConfigurationRepository.save(customConfiguration);
	}

	public List<CustomConfiguration> findAllByConfigKeyIn(List<String> configKey) {
		return this.customConfigurationRepository.findAllByConfigKeyIn(configKey);
	}

}
