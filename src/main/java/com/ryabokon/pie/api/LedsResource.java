package com.ryabokon.pie.api;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.stereotype.*;

import com.ryabokon.pie.api.services.*;

@Component
@Path("/")
public class LedsResource {

	private final LedService ledService = new LedService(25);
	private final HardwareService hardwareService = new HardwareService();

	@GET
	@Path("/leds")
	@Produces({ "application/json" })
	public Response getLedsList() {
		String output = ledService.getLedsAsString();
		return Response.status(200).entity(output).build();
	}

	@PUT
	@Path("/leds/{hex}")
	public Response fillLeds(@PathParam("hex") String hex) {

		ledService.fillLeds(hex);
		hardwareService.sendData(ledService.getLedsAsByteArray());

		return Response.status(200).build();
	}

	@GET
	@Path("/leds/{id}")
	public Response getLedDetails(@PathParam("id") Integer id) {
		String output = "Led " + id + " : " + ledService.getLedColor(id);
		return Response.status(200).entity(output).build();

	}

	@PUT
	@Path("/leds/{id}/{hex}")
	public Response setLedColor(@PathParam("id") Integer id, @PathParam("hex") String hex) {

		ledService.setLedColor(id, hex);
		hardwareService.sendData(ledService.getLedsAsByteArray());

		String output = ledService.getLedsAsString();
		return Response.status(200).entity(output).build();
	}
}