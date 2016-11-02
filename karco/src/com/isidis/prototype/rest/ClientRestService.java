package com.isidis.prototype.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import com.isidis.prototype.bean.Client;
import com.isidis.prototype.bean.GenericResponse;
import com.isidis.prototype.service.ClientService;

@Component
@Validated
public class ClientRestService implements ClientService{

	@Autowired
	private ClientRespository clientRespository;
	
	private static Map<Integer, Client> clients = new HashMap<Integer, Client>();
	
	@Override
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
	public Response deleteClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client getDummyEmployee(@PathParam("id") int id){
		Client c = new Client();
		c.setNom("Varadaradjou");
		c.setPrenom("Victor");
		c.setId(id);
		return c;
	}

	@Override
	public Client[] getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}