package cl.pokedex.bns.domain.pokeapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class MetaTargetEvolution  extends MetaTargetEvolutionList {
	
	private MetaSpecies species;
	
}
