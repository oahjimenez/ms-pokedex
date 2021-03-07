package cl.pokedex.bns.domain;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Pokemon {

	private Integer id;
	private String name;
	private Integer weight;
	private List<Type> types;
	private List<Ability> abilities;
	private String icon_url;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return Boolean.TRUE;
		}
		if (!(obj instanceof Pokemon)) {
			return Boolean.FALSE;
		}
		Pokemon other = (Pokemon) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
