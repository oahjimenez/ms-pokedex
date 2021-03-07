package cl.pokedex.bns.domain.pokeapi;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* PokeApi evolution mirror pojo
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@NoArgsConstructor
public class MetaEvolutionChain {
	
	private MetaTargetEvolutionList chain;

}
