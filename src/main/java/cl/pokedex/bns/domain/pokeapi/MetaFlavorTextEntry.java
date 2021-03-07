package cl.pokedex.bns.domain.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaFlavorTextEntry {

	@JsonProperty("flavor_text")
	private String flavorText;
	
	private MetaLanguage language;

}
