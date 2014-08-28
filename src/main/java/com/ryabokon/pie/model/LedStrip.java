package com.ryabokon.pie.model;

import java.awt.Color;
import java.util.HashMap;

public class LedStrip {

	private final int size;
	private final HashMap<Integer, Color> pixels;

	public LedStrip() {
		this(25);
	}

	public LedStrip(int size) {
		this.size = size;
		this.pixels = new HashMap<Integer, Color>(size);
		fillPixels(Color.BLACK);
	}

	public void setPixel(int position, Color color) throws IndexOutOfBoundsException {
		if (doesPixelFitStrip(position)) {
			pixels.put(position, color);
		}
	}

	public Color getPixel(int position) {
		return pixels.get(position);
	}

	public void fillPixels(Color color) {
		for (int i = 0; i < size; i++) {
			pixels.put(i, color);
		}
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {

		HashMap<Integer, String> hexes = new HashMap<Integer, String>();
		for (int i = 0; i < size; i++) {
			String hex = "#" + Integer.toHexString(pixels.get(i).getRGB()).substring(2).toUpperCase();
			hexes.put(i, hex);
		}

		return hexes.toString();
	}

	public byte[] toArray() {
		byte[] data = new byte[size * 3];
		for (Integer i : pixels.keySet()) {
			Color pixel = pixels.get(i);
			byte[] src = new byte[] { (byte) pixel.getRed(), (byte) pixel.getGreen(), (byte) pixel.getBlue() };
			System.arraycopy(src, 0, data, i * 3, 3);
		}
		return data;
	}

	public HashMap<Integer, Color> getPixels() {
		return pixels;
	}

	private boolean doesPixelFitStrip(int position) {
		return (position >= 0 && position < size);
	}

}
