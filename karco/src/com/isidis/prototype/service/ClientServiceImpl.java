package com.isidis.prototype.service;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.isidis.prototype.bean.Client;
import com.isidis.prototype.bean.GenericResponse;

public class ClientServiceImpl implements ClientService{

	private static Map<Integer, Client> clients = new HashMap<Integer, Client>();
	
	@Override
	@POST
	@Path("/add")
	public Response addClient(Client c) {
		GenericResponse response = new GenericResponse();
		if(clients.get(c.getId()) != null){
			response.setStatus(false);
			response.setMessage("Client already exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		clients.put(c.getId(), c);
		response.setStatus(true);
		response.setMessage("Client created successfully");
		return Response.ok(response).build();
	}

	@Override
	@DELETE
	@Path("/{id}/delete")
	public Response deleteClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/{id}/getDummy")
	public Client getDummyEmployee(@PathParam("id") int id){
		Client c = new Client();
		c.setNom("Varadaradjou");
		c.setPrenom("Victor");
		c.setId(id);
		return c;
	}
	
	
	@Override
	@GET
	@Path("/{id}/get")
	public Client getClient(@PathParam("id") int id) {
		return clients.get(id);
	}

	@Override
	@GET
	@Path("/{id}/getAll")
	public Client[] getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

}