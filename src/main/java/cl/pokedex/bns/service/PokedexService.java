package cl.pokedex.bns.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pokedex.bns.constants.Language;
import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.domain.PokemonDetails;
import cl.pokedex.bns.domain.pokeapi.MetaEvolutionChain;
import cl.pokedex.bns.domain.pokeapi.MetaPokemon;
import cl.pokedex.bns.domain.pokeapi.MetaSpeciesDetail;
import cl.pokedex.bns.factory.PokemonFactory;
import cl.pokedex.bns.repository.PokedexRepository;
import lombok.AllArgsConstructor;

/**
* Pokedex business logic - Service Layer
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@AllArgsConstructor
@Service
public class PokedexService {

	protected final PokedexRepository pokedexRepository;
	protected final PokemonFactory factory;
	
	/**
	 * Get pokedex from given offset
	 * @param limit total items displayed
	 * @param offset pokedex start offset
	 * @param pokemonId pokemon identifier, supports its id and name
	 * @return Pokemon
	 */
	public Object getPokedex(String offset, String limit) {
		return pokedexRepository.getPokedex(offset,limit);
	}
	
	/**
	 * Get pokemon basic info from pokemon id
	 * @param pokemonId pokemon identifier, supports its id and name
	 * @return Pokemon
	 */
	public Pokemon getPokemonInfo(String pokemonId) {
		return factory.getPokemon(pokedexRepository.getPokemonInfo(pokemonId));
	}
	

	/**
	 * Get pokemon evolutions and detailed information from the pokemon id
	 * @param pokemonId identifier of the pokemon
	 * @return PokemonDetails
	 */
	public PokemonDetails getPokemonDetails(String pokemonId) {
		MetaPokemon metaPokemon = pokedexRepository.getPokemonInfo(pokemonId);
		MetaSpeciesDetail speciesInfo = pokedexRepository.getSpeciesInfo(metaPokemon.getSpecies().getUrl());
		MetaEvolutionChain metaEvolutionChain = pokedexRepository.getEvolutionChain(speciesInfo.getEvolutionChain().getUrl());
		List<Pokemon> evolutions = factory.getEvolutions(metaEvolutionChain);
		removePokemon(evolutions,metaPokemon.getName());
		return factory.getPokemonDetails(factory.getPokemon(metaPokemon),speciesInfo,evolutions,Language.SPANISH);
	}
	
	/**
	 * Removes given pokemon name from pokemon list
	 * @param pokemons list of pokemon, pokemonName name to be removed
	 */
	protected void removePokemon(List<Pokemon> pokemons, String pokemonName) {
		pokemons.removeIf(p -> p.getName().equalsIgnoreCase(pokemonName));
	}
	
}