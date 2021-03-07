package cl.pokedex.bns.factory;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cl.pokedex.bns.domain.Ability;
import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.domain.Type;
import cl.pokedex.bns.domain.pokeapi.MetaAbilityWrapper;
import cl.pokedex.bns.domain.pokeapi.MetaPokemon;
import cl.pokedex.bns.domain.pokeapi.MetaTypeWrapper;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PokemonFactory {

	public Pokemon getPokemon(MetaPokemon metaPokemon) {
		return Pokemon.builder()
				.weight(metaPokemon.getWeight())
				.types(metaPokemon.getTypes().stream().map(this::getType).collect(Collectors.toList()))
				.abilities(metaPokemon.getAbilities().stream().map(this::getAbility).collect(Collectors.toList()))
				.build();
	}
	
	protected Ability getAbility(MetaAbilityWrapper metaAbilityWrapper) {
		return Ability.builder()
				.name(metaAbilityWrapper.getAbility().getName())
				.build();
	}
	
	protected Type getType(MetaTypeWrapper metaTypeWrapper) {
		return Type.builder()
				.name(metaTypeWrapper.getType().getName())
				.build();
	}

}
