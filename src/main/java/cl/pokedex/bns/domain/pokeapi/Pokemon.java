package cl.pokedex.bns.domain.pokeapi;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Pokemon {
	private Integer weight;
	private List<MetaType> types;
	private List<MetaAbility> abilities;
}
