package de.unipotsdam.cordova.wifiservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/ssids")
public class WifiReaderService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String readSsids() {
		try {
			WifiReader reader = new WifiReader();
			WifiInfo[] ssids = reader.readWifis();
			return new ObjectMapper().writeValueAsString(ssids);
		} catch (Exception e) {
			Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			throw new WebApplicationException(response);
		}
	}
}
