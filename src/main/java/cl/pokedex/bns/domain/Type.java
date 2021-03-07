package cl.pokedex.bns.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Defines a Pokemon type
* 
* @version 1.0.0
* @author Oswaldo Jimenez
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {
	
	private String name;
	
}
