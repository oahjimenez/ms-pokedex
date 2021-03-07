package cl.pokedex.bns.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cl.pokedex.bns.constants.Language;
import cl.pokedex.bns.domain.Ability;
import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.domain.PokemonDetails;
import cl.pokedex.bns.domain.Type;
import cl.pokedex.bns.domain.pokeapi.MetaAbilityWrapper;
import cl.pokedex.bns.domain.pokeapi.MetaEvolutionChain;
import cl.pokedex.bns.domain.pokeapi.MetaFlavorTextEntry;
import cl.pokedex.bns.domain.pokeapi.MetaPokemon;
import cl.pokedex.bns.domain.pokeapi.MetaSpeciesDetail;
import cl.pokedex.bns.domain.pokeapi.MetaTargetEvolution;
import cl.pokedex.bns.domain.pokeapi.MetaTypeWrapper;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PokemonFactory {

	public Pokemon getPokemon(MetaPokemon metaPokemon) {
		return Pokemon.builder()
				.id(metaPokemon.getId())
				.name(metaPokemon.getName())
				.weight(metaPokemon.getWeight())
				.icon_url(metaPokemon.getSprites().getFrontDefault())
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

	public List<Pokemon> getEvolutions(MetaEvolutionChain metaEvolutionChain) {
		List<Pokemon> evolutions = new ArrayList<>();
		appendEvolutions(metaEvolutionChain.getChain().getEvolvesTo(),evolutions);
		return evolutions;
	}
	
	public void appendEvolutions(List<MetaTargetEvolution> evolutionTargets,List<Pokemon> evolutions) {
		if (!Objects.nonNull(evolutionTargets) || evolutionTargets.isEmpty()) {
			return;
		}
		for (int i=0;i<evolutionTargets.size();i++) {
			Pokemon pokemon = Pokemon.builder().name(evolutionTargets.get(i).getSpecies().getName()).build();
			evolutions.add(pokemon);
			appendEvolutions(evolutionTargets.get(i).getEvolvesTo(),evolutions);
		}
	}
	public PokemonDetails getPokemonDetails(Pokemon pokemon,MetaSpeciesDetail speciesDetail, List<Pokemon> evolutions,Language language) {
		MetaFlavorTextEntry metaFlavorTextEntry = speciesDetail.getFlavorTextEntries().stream().filter(ft -> ft.getLanguage().getName().equalsIgnoreCase(language.getKey())).findFirst().get();
		return PokemonDetails.builder()
				.pokemon(pokemon)
				.description(metaFlavorTextEntry.getFlavorText())
				.language(metaFlavorTextEntry.getLanguage().getName())
				.evolutions(evolutions)
				.build();
	}
}
