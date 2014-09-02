package com.ryabokon.pie;

import org.junit.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.ryabokon.pie.model.*;

public class JacksonTest {

	@Test
	public void ledsHashToJacksonTest() throws JsonProcessingException {

		LedStrip leds = new LedStrip(5);
		leds.setLedColor(0, "000000");
		leds.setLedColor(1, "FF0000");
		leds.setLedColor(2, "00FF00");
		leds.setLedColor(3, "0000FF");
		leds.setLedColor(4, "FFFFFF");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(leds);

	}
}
