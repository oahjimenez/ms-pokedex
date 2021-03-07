package cl.pokedex.bns.domain.pokeapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* PokeApi evolution wrapper pojo
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@NoArgsConstructor
public class MetaTargetEvolutionList {

	@JsonProperty("evolves_to")
	private List<MetaTargetEvolution> evolvesTo;
	
}
