package com.covid19app.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class describes a source subobject obtained from the API call. The source has an ID and name
 * and a toString() method to return the JSON object in a string.
 * @author Neil An
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {
	private String id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Source{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
