package cl.pokedex.bns.domain.pokeapi;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MetaPokemon {
	private Integer weight;
	private List<MetaTypeWrapper> types;
	private List<MetaAbilityWrapper> abilities;
}