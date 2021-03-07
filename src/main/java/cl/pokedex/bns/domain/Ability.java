package cl.pokedex.bns.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Describes a Pokemon Ability
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
	private String name;
}
