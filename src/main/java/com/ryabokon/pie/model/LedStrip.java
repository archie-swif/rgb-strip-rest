package com.ryabokon.pie.model;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

public class LedStrip {

	@JsonIgnore
	private final int size;
	private final HashMap<Integer, String> leds;

	public LedStrip(int size) {
		this.size = size;
		this.leds = new HashMap<Integer, String>(size);

	}

	public void setLedColor(int position, String color) {
		leds.put(position, color);
	}

	public String getLedColor(int position) {
		return leds.get(position);
	}

	public HashMap<Integer, String> getLeds() {
		return leds;
	}

	public int getSize() {
		return size;
	}
}
