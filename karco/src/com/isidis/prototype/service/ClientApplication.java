package com.isidis.prototype.service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class ClientApplication extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	
	public ClientApplication(){
		singletons.add(new ClientServiceImpl());
	}
	
	public Set<Object> getSingletons(){
		return singletons;
	}
}
