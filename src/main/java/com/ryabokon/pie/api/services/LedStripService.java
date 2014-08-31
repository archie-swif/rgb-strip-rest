package com.ryabokon.pie.api.services;

import java.awt.*;
import java.util.*;

import com.ryabokon.pie.model.*;

public class LedStripService {

	private final LedStrip ledStrip;

	public LedStripService() {
		ledStrip = new LedStrip();
		fillPixels(Color.BLACK);
	}

	public LedStripService(int stripSize) {
		ledStrip = new LedStrip(stripSize);
		fillPixels(Color.BLACK);
	}

	public Color getPixel(int position) {
		return ledStrip.getPixel(position);
	}

	public void setPixel(int position, Color color) {
		if (position >= 0 && position < ledStrip.getSize()) {
			ledStrip.setPixel(position, color);
		}
	}

	public void fillPixels(Color color) {
		for (int i = 0; i < ledStrip.getSize(); i++) {
			ledStrip.setPixel(i, color);
		}
	}

	public int getStripSize() {
		return ledStrip.getSize();
	}

	public LedStrip getStrip() {
		return ledStrip;
	}

	public byte[] getStripAsByteArray() {
		byte[] data = new byte[ledStrip.getSize() * 3];
		for (int i = 0; i < ledStrip.getSize(); i++) {
			Color pixel = ledStrip.getPixel(i);
			byte[] src = new byte[] { (byte) pixel.getRed(), (byte) pixel.getGreen(), (byte) pixel.getBlue() };
			System.arraycopy(src, 0, data, i * 3, 3);
		}
		return data;
	}

	public String getStripAsString() {
		TreeMap<Integer, String> hexes = new TreeMap<Integer, String>();
		for (int i = 0; i < ledStrip.getSize(); i++) {
			String hex = "#" + Integer.toHexString(ledStrip.getPixel(i).getRGB()).substring(2).toUpperCase();
			hexes.put(i, hex);
		}

		return hexes.toString();
	}

}
