package com.isidis.prototype.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.isidis.prototype.bean.Client;

@Repository
public class ClientRespository {
	private final List<Client> clients = new ArrayList<Client>();

	private int lastId = 0;

	public ClientRespository() {
		String[] names = new String[] { "John", "Steve", "Bill" };
		for (int i = 0; i < 5; ++i) {
			Client client = new Client();
			client.setId(lastId++);
			client.setNom(names[i % 3] + i);
			client.setPrenom(names[i % 3] + i);
			client.setEmail(names[i % 3] + i);
			clients.add(client);
		}
	}

	public List<Client> getClients(int limit, int offset) {
		return clients.subList(offset, Math.min(offset + limit, clients.size()));
	}

	synchronized public void addUsers(List<Client> users) {
		for (Client client : clients) {
			client.setId(lastId++);
			addClient(client);
		}
	}

	synchronized public void addClient(Client client) {
		client.setId(lastId++);
		this.clients.add(client);
	}
}
