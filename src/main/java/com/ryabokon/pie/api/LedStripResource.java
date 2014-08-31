package com.ryabokon.pie.api;

import java.awt.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.stereotype.Component;

import com.ryabokon.pie.api.services.*;

@Component
@Path("/")
public class LedStripResource {

	private final LedStripService ledService = new LedStripService();
	private final HardwareService hardwareService = new HardwareService();

	@GET
	@Path("/leds")
	public Response getLedsList() {
		String output = ledService.getStripAsString();
		return Response.status(200).entity(output).build();
	}

	@PUT
	@Path("/leds/{hex}")
	public Response paintAllLeds(@PathParam("hex") String hex) {
		hex = "#" + hex;
		Color color = Color.decode(hex);
		ledService.fillPixels(color);

		hardwareService.sendData(ledService.getStripAsByteArray());

		String output = ledService.getStripAsString();
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/leds/{id}")
	public Response getLedDetails(@PathParam("id") Integer id) {
		String output = "Led " + id + " : " + ledService.getPixel(id);
		return Response.status(200).entity(output).build();

	}

	@PUT
	@Path("/leds/{id}/{hex}")
	public Response setLedColor(@PathParam("id") Integer id, @PathParam("hex") String hex) {
		hex = "#" + hex;
		Color color = Color.decode(hex);
		ledService.setPixel(id, color);
		hardwareService.sendData(ledService.getStripAsByteArray());

		String output = ledService.getStripAsString();
		return Response.status(200).entity(output).build();
	}
}