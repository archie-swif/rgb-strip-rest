package com.ryabokon.pie.api.services;

import java.awt.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.ryabokon.pie.model.*;
import com.ryabokon.pie.tools.*;

public class LedStripService {

	private final ObjectMapper mapper = new ObjectMapper();
	private final LedStrip leds;

	public LedStripService(int stripSize) {
		leds = new LedStrip(stripSize);
		fillLeds("000000");
	}

	public String getLedColor(int position) {
		return leds.getLedColor(position);
	}

	public void setLedColor(int position, String color) {
		if (position >= 0 && position < leds.getSize()) {
			leds.setLedColor(position, color);
		}
	}

	public void fillLeds(String color) {
		for (int i = 0; i < leds.getSize(); i++) {
			leds.setLedColor(i, color);
		}
	}

	public int getLedsSize() {
		return leds.getSize();
	}

	public LedStrip getLeds() {
		return leds;
	}

	public byte[] getLedsAsByteArray() {
		byte[] data = new byte[leds.getSize() * 3];

		for (int i = 0; i < leds.getSize(); i++) {

			String pixel = leds.getLedColor(i);

			// TODO catch if smth wrong comes in
			Color color = Color.decode("#" + pixel);

			int r = color.getRed();
			int g = color.getGreen();
			int b = color.getBlue();

			r = ColorTools.getGammaCorrectedColor(r);
			g = ColorTools.getGammaCorrectedColor(g);
			b = ColorTools.getGammaCorrectedColor(b);

			byte[] src = new byte[] { (byte) r, (byte) g, (byte) b };

			System.arraycopy(src, 0, data, i * 3, 3);
		}
		return data;
	}

	public String getLedsAsString() {
		String json = null;

		try {
			json = mapper.writeValueAsString(leds);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

}
