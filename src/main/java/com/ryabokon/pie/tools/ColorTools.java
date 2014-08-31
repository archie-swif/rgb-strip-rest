package com.ryabokon.pie.tools;

public class ColorTools {

	private static final float MAX_IN = 255f;
	private static final float MAX_OUT = 255f;
	private static final float GAMMA = 2.8f;

	private static int[] correctionTable;

	static {
		correctionTable = new int[256];
		for (int i = 0; i < 256; i++) {
			correctionTable[i] = getCorrectedValue(i);
		}
	}

	public static int getGammaCorrectedColor(int value) {
		return correctionTable[value];
	}

	private static int getCorrectedValue(int value) {
		return (int) (Math.pow((value / MAX_IN), GAMMA) * MAX_OUT + 0.5);
	}
}
