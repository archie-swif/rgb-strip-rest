package com.ryabokon.pie;

import org.junit.*;

import com.ryabokon.pie.api.services.*;

public class LedStripServiceTest {

	private final String BLACK = "000000";
	private final String RED = "FF0000";
	private final String GREEN = "00FF00";
	private final String BLUE = "0000FF";
	private final String WHITE = "FFFFFF";
	private final String BEBEBE = "BEBEBE";

	@Test
	public void stripIsBlackByDefaultTest() {
		LedStripService ledService = new LedStripService(25);

		for (int i = 0; i < ledService.getLedsSize(); i++) {
			String color = ledService.getLedColor(i);
			Assert.assertEquals("Default color is black", BLACK, color);
		}

	}

	@Test
	public void bigSizedStripIsBlackByDefaultTest() {
		LedStripService ledService = new LedStripService(100);

		for (int i = 0; i < ledService.getLedsSize(); i++) {
			String color = ledService.getLedColor(i);
			Assert.assertEquals("Default color is black", BLACK, color);
		}

	}

	@Test
	public void setPixelColorTest() {

		LedStripService ledService = new LedStripService(20);
		ledService.setLedColor(5, RED);

		for (int i = 0; i < ledService.getLedsSize(); i++) {

			String actual = ledService.getLedColor(i);

			if (i == 5) {
				Assert.assertEquals("Pixel 5 should be red", RED, actual);
			} else {
				Assert.assertEquals("Other pixels should be left intact", BLACK, actual);
			}
		}

	}

	@Test
	public void fillPixelsTest() {
		LedStripService ledService = new LedStripService(42);
		String fillColor = "BEBEBE";
		ledService.fillLeds(fillColor);

		for (int i = 0; i < ledService.getLedsSize(); i++) {
			String actual = ledService.getLedColor(i);
			Assert.assertEquals("Pixels should be filled with BEBEBE", fillColor, actual);
		}

	}

	@Test
	public void pixelsToArrayTest() {
		LedStripService ledService = new LedStripService(5);
		ledService.setLedColor(0, "000000");
		ledService.setLedColor(1, "FF0000");
		ledService.setLedColor(2, "00FF00");
		ledService.setLedColor(3, "0000FF");
		ledService.setLedColor(4, "FFFFFF");

		byte[] expectedBytes = { 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, -1, -1, -1 };
		byte[] actualBytes = ledService.getLedsAsByteArray();

		Assert.assertArrayEquals(expectedBytes, actualBytes);
	}

	@Test
	public void pixelsToArrayWithGammaCorrectionTest() {
		LedStripService ledService = new LedStripService(1);
		ledService.setLedColor(0, "204080");

		byte[] expectedBytes = { 1, 5, 37 };
		byte[] actualBytes = ledService.getLedsAsByteArray();

		Assert.assertArrayEquals(expectedBytes, actualBytes);
	}

	@Test
	public void pixelsToStringTest() {
		LedStripService ledService = new LedStripService(5);
		ledService.setLedColor(0, "000000");
		ledService.setLedColor(1, "FF0000");
		ledService.setLedColor(2, "00FF00");
		ledService.setLedColor(3, "0000FF");
		ledService.setLedColor(4, "FFFFFF");

		String expectedString = "{\"leds\":{\"0\":\"000000\",\"1\":\"FF0000\",\"2\":\"00FF00\",\"3\":\"0000FF\",\"4\":\"FFFFFF\"}}";
		String actualString = ledService.getLedsAsString();

		Assert.assertEquals(expectedString, actualString);
	}

}
