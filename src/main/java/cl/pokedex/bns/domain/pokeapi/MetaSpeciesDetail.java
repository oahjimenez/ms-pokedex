package cl.pokedex.bns.domain.pokeapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaSpeciesDetail {

	@JsonProperty("evolution_chain")
	public MetaSpeciesDetailChain evolutionChain;

	@JsonProperty("flavor_text_entries")
	public List<MetaFlavorTextEntry> flavorTextEntries;
	
	
}
