package cl.pokedex.bns.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

	private Integer weight;
	private List<Type> types;
	private List<Ability> abilities;
}
