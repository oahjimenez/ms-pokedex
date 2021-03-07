package cl.pokedex.bns.domain.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaSprite {
	
	@JsonProperty("front_default")
	private String frontDefault;
	
}
