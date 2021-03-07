package cl.pokedex.bns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping(path="/evolution/{id}")
	public Object getEvolution(@PathVariable("id") Integer pokemonId) {
		return this.pokedexService.getEvolutionInfo(pokemonId);
	}

}
