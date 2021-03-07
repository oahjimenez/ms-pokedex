package cl.pokedex.bns.domain.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* PokeApi descriptions mirror pojo
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@NoArgsConstructor
public class MetaFlavorTextEntry {

	@JsonProperty("flavor_text")
	private String flavorText;
	
	private MetaLanguage language;

}
