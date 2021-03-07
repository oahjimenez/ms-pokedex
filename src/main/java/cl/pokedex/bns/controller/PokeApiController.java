package cl.pokedex.bns.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.service.PokedexService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class PokeApiController {
	
	protected final PokedexService pokedexService;
	
	@GetMapping("/pokedex")
	public Object getPokedex() {
		return this.pokedexService.getPokedex();
	}
	
	@GetMapping(path="/pokemon/{id}")
	public Pokemon getPokemon(@PathVariable("id") Integer pokemonId) {
		return this.pokedexService.getPokemonInfo(pokemonId);
	}
	
	@GetMapping(path="/evolutions/{id}")
	public List<Pokemon> getEvolution(@PathVariable("id") Integer pokemonId) {
		return this.pokedexService.getEvolutions(pokemonId);
	}

}
