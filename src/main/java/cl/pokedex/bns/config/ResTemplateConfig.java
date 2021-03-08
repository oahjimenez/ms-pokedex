package cl.pokedex.bns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
* Configures and publish rest template to the application context
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Configuration
public class ResTemplateConfig {
	
	/**
	 * Instantiates and publish a default rest template 
	 * @return new default rest template
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
