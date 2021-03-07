package cl.pokedex.bns.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.pokedex.bns.domain.pokeapi.Pokemon;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PokedexRepository {

	public static final String POKEAPI_POKEDEX_URL = "https://pokeapi.co/api/v2/pokemon/";
	public static final String POKEAPI_EVOLUTION_URL = "https://pokeapi.co/api/v2/evolution-chain/";
	
	protected final RestTemplate restTemplate;
	
	public Object getPokedex() {
		return this.restTemplate.getForObject(POKEAPI_POKEDEX_URL,Object.class);
	}
	
	public Pokemon getPokemonInfo(Integer pokemonId) {
		return this.restTemplate.getForObject(POKEAPI_POKEDEX_URL.concat(String.valueOf(pokemonId)),Pokemon.class);
	}
	
	public Object getEvolutionInfo(Integer pokemonId) {
		return this.restTemplate.getForObject(POKEAPI_EVOLUTION_URL.concat(String.valueOf(pokemonId)),String.class);
	}
}
