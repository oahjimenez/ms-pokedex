package cl.pokedex.bns.domain.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* PokeApi sprite pojo
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@NoArgsConstructor
public class MetaSprite {
	
	@JsonProperty("front_default")
	private String frontDefault;
	
}
