package cl.pokedex.bns.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Pokemon detailed information
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDetails {
	
	private Pokemon pokemon;
	private String description;
	private String language;
	private List<Pokemon> evolutions;

}
