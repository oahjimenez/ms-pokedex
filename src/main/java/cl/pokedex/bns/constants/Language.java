package cl.pokedex.bns.constants;

import lombok.Getter;

@Getter
public enum Language {
	SPANISH("ES","Spanish language");
	
	Language(String key, String description) {
		this.key = key;
		this.description = description;
	}
	private String key;
	private String description;

}
