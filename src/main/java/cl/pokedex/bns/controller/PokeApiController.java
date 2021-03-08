package cl.pokedex.bns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.domain.PokemonDetails;
import cl.pokedex.bns.service.PokedexService;
import lombok.AllArgsConstructor;

/**
* Pokedex Main entry point controller
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@AllArgsConstructor
@RestController
public class PokeApiController {
	
	protected final PokedexService pokedexService;
	
	/**
	 * Pokemon list endpoint
	 * @return pokeApi pokedex response
	 */
	@CrossOrigin
	@GetMapping("/pokedex")
	public Object getPokedex(@RequestParam(defaultValue = "0") String offset,
			                 @RequestParam(defaultValue = "0") String limit) {
		return this.pokedexService.getPokedex(offset,limit);
	}
	
	/**
	 * Gets pokemon basic information by pokemon id
	 * @return pokemon object
	 */
	@CrossOrigin
	@GetMapping(path="/pokemon/{id}")
	public Pokemon getPokemon(@PathVariable("id") String pokemonId) {
		return this.pokedexService.getPokemonInfo(pokemonId);
	}

	/**
	 * Gets pokemon detailed information by pokemon id
	 * @return pokemon details object
	 */
	@CrossOrigin
	@GetMapping(path="/pokemon/{id}/details")
	public PokemonDetails getPokemonDetails(@PathVariable("id") String pokemonId) {
		return this.pokedexService.getPokemonDetails(pokemonId);
	}

}
