package cl.pokedex.bns.domain.pokeapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* PokeApi evolution pojo
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class MetaTargetEvolution  extends MetaTargetEvolutionList {
	
	private MetaSpecies species;
	
}
