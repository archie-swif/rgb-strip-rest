package com.ryabokon.pie.model;

import java.awt.*;

public class LedStrip {

	private final Color[] pixels;
	private final int size;

	public LedStrip() {
		this.pixels = new Color[25];
		this.size = 25;
	}

	public LedStrip(int size) {
		this.pixels = new Color[size];
		this.size = size;
	}

	public void setPixel(int position, Color color) {
		pixels[position] = color;
	}

	public Color getPixel(int position) {
		return pixels[position];
	}

	public int getSize() {
		return size;
	}
}
