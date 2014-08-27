package com.ryabokon.pie.api;

import java.awt.Color;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.ryabokon.pie.model.LedStrip;

@Path("/")
public class LedStripService {

	private LedStrip strip = new LedStrip();

	@GET
	@Path("/{id}")
	public Response getLedDetails(@PathParam("id") Integer id) {
		String output = "Led " + id + " : " + strip.getPixel(id);
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/")
	public Response getLedsList() {
		String output = strip.toString();
		return Response.status(200).entity(output).build();
	}

	@PUT
	@Path("/{id}/{hex}")
	public Response setLedColor(@PathParam("id") Integer id,
			@PathParam("hex") String hex) {
		hex = "#" + hex;
		Color color = Color.decode(hex);
		strip.setPixel(id, color);

		String output = strip.toString();
		return Response.status(200).entity(output).build();
	}
}