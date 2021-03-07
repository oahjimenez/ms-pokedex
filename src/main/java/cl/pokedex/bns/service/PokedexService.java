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
	
}
