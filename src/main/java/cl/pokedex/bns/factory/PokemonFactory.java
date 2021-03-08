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

/**
* Pokedex pojos generator
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Component
@NoArgsConstructor
public class PokemonFactory {

	/**
	 * Get business pokemon from pokeApi pokemon metadata
	 * @param metaPokemon raw pokeApi data that describes a pokemon
	 * @return business Pokemon
	 */
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
	
	/**
	 * Get ability details from pokeApi ability metadata
	 * @param metaAbilityWrapper raw pokeApi data that describes an ability
	 * @return business ability
	 */
	protected Ability getAbility(MetaAbilityWrapper metaAbilityWrapper) {
		return Ability.builder()
				.name(metaAbilityWrapper.getAbility().getName())
				.build();
	}
	
	/**
	 * Get type details from pokeApi type metadata
	 * @param metaTypeWrapper raw pokeApi data that describes a type
	 * @return business type
	 */
	protected Type getType(MetaTypeWrapper metaTypeWrapper) {
		return Type.builder()
				.name(metaTypeWrapper.getType().getName())
				.build();
	}

	/**
	 * Get list of pokemon evolutions from pokeApi evolution chain
	 * @param metaEvolutionChain raw pokeApi evolution medatata
	 * @return list of pokemon evolutions
	 */
	public List<Pokemon> getEvolutions(MetaEvolutionChain metaEvolutionChain) {
		List<Pokemon> evolutions = new ArrayList<>();
		appendEvolutions(metaEvolutionChain.getChain().getEvolvesTo(),evolutions);
		return evolutions;
	}

	/**
	 * Populates list by transversing pokeApi evolution chain
	 * @param evolutionTargets pokeApi recursive evolution chain
	 * @param evolution evolution list to populate
	 * @return list of pokemon evolutions
	 */
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
	
	/**
	 * Groups pokemon details in business pojo
	 * @param pokemon owning the details
	 * @param speciesDetail pokeApi species details
	 * @oaram evolutions pokemon evolution list
	 * @param language to look up the details
	 * @return pokemon details business pojo
	 */
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
