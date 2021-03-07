package cl.pokedex.bns.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pokedex.bns.domain.Pokemon;
import cl.pokedex.bns.domain.pokeapi.MetaEvolutionChain;
import cl.pokedex.bns.domain.pokeapi.MetaPokemon;
import cl.pokedex.bns.domain.pokeapi.MetaSpeciesDetail;
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
	
	public List<Pokemon> getEvolutions(Integer pokemonId) {
		MetaPokemon metaPokemon = pokedexRepository.getPokemonInfo(pokemonId);
		MetaSpeciesDetail speciesInfo = pokedexRepository.getSpeciesInfo(metaPokemon.getSpecies().getUrl());
		MetaEvolutionChain metaEvolutionChain = pokedexRepository.getEvolutionChain(speciesInfo.getEvolutionChain().getUrl());
		List<Pokemon> evolutions = factory.getEvolutions(metaEvolutionChain);
		removePokemon(evolutions,metaPokemon.getName());
		return evolutions;
	}
	
	protected void removePokemon(List<Pokemon> pokemons, String pokemonName) {
		pokemons.removeIf(p -> p.getName().equalsIgnoreCase(pokemonName));
	}
	
}
