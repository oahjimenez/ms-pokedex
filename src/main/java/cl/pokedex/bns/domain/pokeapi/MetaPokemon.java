package cl.pokedex.bns.domain.pokeapi;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* PokeApi raw pokemon pojo
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@NoArgsConstructor
public class MetaPokemon {
	
	private Integer id;
	private String name;
	private Integer weight;
	private List<MetaTypeWrapper> types;
	private List<MetaAbilityWrapper> abilities;
	private MetaSprite sprites;
	private MetaSpecies species;
	
}
