package cl.pokedex.bns.service;

import org.springframework.stereotype.Service;

import cl.pokedex.bns.repository.PokedexRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PokedexService {

	protected final PokedexRepository pokedexRepository;
	
	public Object getPokedex() {
		return pokedexRepository.getPokedex();
	}
	
	public Object getPokemonInfo(Integer pokemonId) {
		return pokedexRepository.getPokemonInfo(pokemonId);
	}
	
	public Object getEvolutionInfo(Integer pokemonId) {
		return pokedexRepository.getEvolutionInfo(pokemonId);
	}
	
}
