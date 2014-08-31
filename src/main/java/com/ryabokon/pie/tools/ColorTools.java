package com.ryabokon.pie.tools;

import java.awt.*;
import java.util.*;

public class ColorTools {

	private static Random random = new Random();

	public static Color getRandomBrightPixel() {

		final float hue = random.nextFloat();
		final float saturation = 1.0f;// 1.0 for brilliant, 0.0 for dull
		final float brightness = 0.1f; // 1.0 for brighter, 0.0 for black

		return Color.getHSBColor(hue, saturation, brightness);
	}

	public static Color getRandomRGBPixel() {

		int r = (int) (random.nextFloat() * 256);
		int g = (int) (random.nextFloat() * 256);
		int b = (int) (random.nextFloat() * 256);
		return new Color(r, g, b);
	}

	public static Color getRandomRainbowPixel() {

		Color color;
		int r = random.nextInt(8);
		{
			switch (r) {
			case 0:
				color = Color.RED;
				break;
			case 1:
				color = Color.getHSBColor(15 / 360f, 1, 1);
				break;
			case 2:
				color = Color.YELLOW;
				break;
			case 3:
				color = Color.getHSBColor(60 / 360f, 1, 1);
				break;
			case 4:
				color = Color.getHSBColor(90 / 360f, 1, 1);
				break;
			case 5:
				color = Color.CYAN;
				break;
			case 6:
				color = Color.BLUE;
				break;
			case 7:
				color = Color.MAGENTA;
				break;
			default:
				color = Color.BLACK;
			}
		}
		return color;
	}

	public static Color getRandomBigRainbowPixel() {

		int r = random.nextInt(24);
		Color color = Color.getHSBColor((15 * r) / 360.0f, 1, 1);
		return color;
	}

	public static Color getHSBPixel(int h, int s, int b) {

		final float hue = h / 360.0f;
		final float saturation = s / 360.0f;
		final float brightness = b / 360.0f;

		return Color.getHSBColor(hue, saturation, brightness);
	}

}
