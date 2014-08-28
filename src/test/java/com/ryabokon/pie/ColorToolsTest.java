package com.ryabokon.pie;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

public class ColorToolsTest {

	@Test
	public void hexToColorTest() {
		String hex = "#00FF00";
		Color color = Color.decode(hex);
		Assert.assertEquals(Color.GREEN, color);
	}

}
