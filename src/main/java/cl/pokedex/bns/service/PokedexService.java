package cl.pokedex.bns.service;

import org.springframework.stereotype.Service;

import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.factory.PokemonFactory;
import cl.pokedex.bns.repository.PokedexRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PokedexService {

	protected final PokedexRepository pokedexRepository;
	protected final PokemonFactory factory;
	
	public Object getPokedex() {
		return pokedexRepository.getPokedex();
	}
	
	public Pokemon getPokemonInfo(Integer pokemonId) {
		return factory.getPokemon(pokedexRepository.getPokemonInfo(pokemonId));
	}
	
	public Object getEvolutionInfo(Integer pokemonId) {
		return pokedexRepository.getEvolutionInfo(pokemonId);
	}
	
}
