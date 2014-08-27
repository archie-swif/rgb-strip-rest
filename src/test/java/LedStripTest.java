import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

import com.ryabokon.pie.model.LedStrip;

public class LedStripTest {

	@Test
	public void createStripTest() {
		LedStrip strip = new LedStrip();
		Assert.assertTrue("Default size is 25", strip.getSize() == 25);

		for (int i = 0; i < strip.getSize(); i++) {
			Color color = strip.getPixel(i);
			Assert.assertEquals("Default color is black", Color.BLACK, color);

		}

	}

	@Test
	public void stripIsBlackByDefaultTest() {
		LedStrip strip = new LedStrip();

		for (int i = 0; i < strip.getSize(); i++) {
			Color color = strip.getPixel(i);
			Assert.assertEquals("Default color is black", Color.BLACK, color);
		}

	}

	@Test
	public void customSizedStripIsBlackByDefaultTest() {
		LedStrip strip = new LedStrip(100);

		for (int i = 0; i < strip.getSize(); i++) {
			Color color = strip.getPixel(i);
			Assert.assertEquals("Default color is black", Color.BLACK, color);
		}

	}

	@Test
	public void setPixelColorTest() {
		LedStrip strip = new LedStrip();
		strip.setPixel(5, Color.RED);

		for (int i = 0; i < strip.getSize(); i++) {
			Color color = strip.getPixel(i);
			if (i == 5) {
				Assert.assertEquals("Pixel 5 should be red", Color.RED, color);
			} else {
				Assert.assertEquals("Other pixels should be left intact",
						Color.BLACK, color);
			}
		}

	}

	@Test
	public void fillPixelsTest() {
		LedStrip strip = new LedStrip();
		strip.fillPixels(Color.CYAN);

		for (int i = 0; i < strip.getSize(); i++) {
			Color color = strip.getPixel(i);
			Assert.assertEquals("Pixels should be filled with CYAN",
					Color.CYAN, color);
		}

	}

	@Test
	public void pixelsToArrayTest() {
		LedStrip strip = new LedStrip(5);
		strip.setPixel(0, Color.BLACK);
		strip.setPixel(1, Color.RED);
		strip.setPixel(2, Color.GREEN);
		strip.setPixel(3, Color.BLUE);
		strip.setPixel(4, Color.WHITE);

		byte[] expectedBytes = { 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, -1, -1,
				-1 };
		byte[] actualBytes = strip.toArray();

		Assert.assertArrayEquals(expectedBytes, actualBytes);
	}

	@Test
	public void pixelsToStringTest() {
		LedStrip strip = new LedStrip(5);
		strip.setPixel(0, Color.BLACK);
		strip.setPixel(1, Color.RED);
		strip.setPixel(2, Color.GREEN);
		strip.setPixel(3, Color.BLUE);
		strip.setPixel(4, Color.WHITE);

		String expectedString = "{0=#000000, 1=#FF0000, 2=#00FF00, 3=#0000FF, 4=#FFFFFF}";
		String actualString = strip.toString();

		Assert.assertEquals(expectedString, actualString);
	}

}
