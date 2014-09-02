package com.ryabokon.pie.model;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

public class Leds {

	@JsonIgnore
	private final int size;
	private final HashMap<Integer, String> ledMap;

	public Leds(int size) {
		this.size = size;
		this.ledMap = new HashMap<Integer, String>(size);

	}

	public void setLedColor(int position, String color) {
		ledMap.put(position, color);
	}

	public String getLedColor(int position) {
		return ledMap.get(position);
	}

	public HashMap<Integer, String> getLeds() {
		return ledMap;
	}

	public int getSize() {
		return size;
	}
}
