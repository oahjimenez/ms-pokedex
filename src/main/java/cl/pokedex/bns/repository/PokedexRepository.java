package cl.pokedex.bns.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.pokedex.bns.domain.pokeapi.MetaEvolutionChain;
import cl.pokedex.bns.domain.pokeapi.MetaPokemon;
import cl.pokedex.bns.domain.pokeapi.MetaSpeciesDetail;
import lombok.AllArgsConstructor;

/**
* Pokedex entry points, integration with PokeApi
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@AllArgsConstructor
@Component
public class PokedexRepository {

	public static final String POKEAPI_POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/";
	public static final String POKEAPI_POKEDEX_URL = POKEAPI_POKEMON_URL.concat("?offset={offset}&limit={limit}");
	public static final String POKEAPI_EVOLUTION_CHAIN_URL = "https://pokeapi.co/api/v2/evolution-chain/";
	
	protected final RestTemplate restTemplate;
	
	public Object getPokedex(String offset, String limit) {
		return this.restTemplate.getForObject(POKEAPI_POKEDEX_URL,Object.class,offset,limit);
	}
	
	public MetaPokemon getPokemonInfo(String pokemonId) {
		return this.restTemplate.getForObject(POKEAPI_POKEMON_URL.concat(pokemonId),MetaPokemon.class);
	}
	
	public MetaEvolutionChain getEvolutionChain(String evolutionChainUrl) {
		return this.restTemplate.getForObject(evolutionChainUrl,MetaEvolutionChain.class);
	}
	
	public MetaSpeciesDetail getSpeciesInfo(String speciesUrl) {
		return this.restTemplate.getForObject(speciesUrl,MetaSpeciesDetail.class);
	}
}
