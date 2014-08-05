package com.ryabokon.pie;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloWorldRest {

	@GET
	@Path("/{id}")
	public Response getLedDetails(@PathParam("id") String parameter) {
		String output = "Led " + parameter + " : " + "OK!";
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/")
	public Response getLedsList() {
		String output = "Leds: 1, 2, 3";
		return Response.status(200).entity(output).build();
	}
}