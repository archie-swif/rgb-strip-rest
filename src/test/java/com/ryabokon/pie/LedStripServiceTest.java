package com.ryabokon.pie;

import java.awt.*;

import org.junit.*;

import com.ryabokon.pie.api.services.*;

public class LedStripServiceTest {

	@Test
	public void createStripTest() {
		LedStripService ledService = new LedStripService();
		Assert.assertTrue("Default size is 25, actual: [" + ledService.getStripSize() + "]",
				ledService.getStripSize() == 25);

		for (int i = 0; i < ledService.getStripSize(); i++) {
			Color color = ledService.getPixel(i);
			Assert.assertEquals("Default color is black", Color.BLACK, color);
		}

	}

	@Test
	public void stripIsBlackByDefaultTest() {
		LedStripService ledService = new LedStripService();

		for (int i = 0; i < ledService.getStripSize(); i++) {
			Color color = ledService.getPixel(i);
			Assert.assertEquals("Default color is black", Color.BLACK, color);
		}

	}

	@Test
	public void customSizedStripIsBlackByDefaultTest() {
		LedStripService ledService = new LedStripService(100);

		for (int i = 0; i < ledService.getStripSize(); i++) {
			Color color = ledService.getPixel(i);
			Assert.assertEquals("Default color is black", Color.BLACK, color);
		}

	}

	@Test
	public void setPixelColorTest() {
		LedStripService ledService = new LedStripService();
		ledService.setPixel(5, Color.RED);

		for (int i = 0; i < ledService.getStripSize(); i++) {
			Color color = ledService.getPixel(i);
			if (i == 5) {
				Assert.assertEquals("Pixel 5 should be red", Color.RED, color);
			} else {
				Assert.assertEquals("Other pixels should be left intact", Color.BLACK, color);
			}
		}

	}

	@Test
	public void fillPixelsTest() {
		LedStripService ledService = new LedStripService();
		ledService.fillPixels(Color.CYAN);

		for (int i = 0; i < ledService.getStripSize(); i++) {
			Color color = ledService.getPixel(i);
			Assert.assertEquals("Pixels should be filled with CYAN", Color.CYAN, color);
		}

	}

	@Test
	public void pixelsToArrayTest() {
		LedStripService ledService = new LedStripService(5);
		ledService.setPixel(0, Color.BLACK);
		ledService.setPixel(1, Color.RED);
		ledService.setPixel(2, Color.GREEN);
		ledService.setPixel(3, Color.BLUE);
		ledService.setPixel(4, Color.WHITE);

		byte[] expectedBytes = { 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, -1, -1, -1 };
		byte[] actualBytes = ledService.getStripAsByteArray(false);

		Assert.assertArrayEquals(expectedBytes, actualBytes);
	}

	@Test
	public void pixelsToArrayWithGammaCorrectionTest() {
		LedStripService ledService = new LedStripService(1);
		ledService.setPixel(0, new Color(32, 64, 128));

		byte[] expectedBytes = { 1, 5, 37 };
		byte[] actualBytes = ledService.getStripAsByteArray(true);

		Assert.assertArrayEquals(expectedBytes, actualBytes);
	}

	@Test
	public void pixelsToStringTest() {
		LedStripService ledService = new LedStripService(5);
		ledService.setPixel(0, Color.BLACK);
		ledService.setPixel(1, Color.RED);
		ledService.setPixel(2, Color.GREEN);
		ledService.setPixel(3, Color.BLUE);
		ledService.setPixel(4, Color.WHITE);

		String expectedString = "{0=#000000, 1=#FF0000, 2=#00FF00, 3=#0000FF, 4=#FFFFFF}";
		String actualString = ledService.getStripAsString();

		Assert.assertEquals(expectedString, actualString);
	}

}
