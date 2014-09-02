package com.ryabokon.pie;

import java.awt.*;

import org.junit.*;

import com.ryabokon.pie.tools.*;

public class ColorToolsTest {

	@Test
	public void hexToColorTest() {
		String hex = "#00FF00";
		Color color = Color.decode(hex);
		Assert.assertEquals(Color.GREEN, color);
	}

	@Test
	public void testGammaCorrctionFunction() {
		int a0 = ColorTools.getGammaCorrectedColor(0);
		int e0 = 0;
		Assert.assertEquals(a0, e0);

		int a1 = ColorTools.getGammaCorrectedColor(32);
		int e1 = 1;
		Assert.assertEquals(a1, e1);

		int a2 = ColorTools.getGammaCorrectedColor(64);
		int e2 = 5;
		Assert.assertEquals(a2, e2);

		int a3 = ColorTools.getGammaCorrectedColor(128);
		int e3 = 37;
		Assert.assertEquals(a3, e3);

		int a4 = ColorTools.getGammaCorrectedColor(255);
		int e4 = 255;
		Assert.assertEquals(a4, e4);
	}

}
