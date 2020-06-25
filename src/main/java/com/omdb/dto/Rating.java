package com.omdb.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -430334844799077630L;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("Value")
	private String value;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
