package cl.pokedex.bns.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
