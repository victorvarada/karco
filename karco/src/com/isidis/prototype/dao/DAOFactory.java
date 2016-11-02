package com.isidis.prototype.dao;

import com.isidis.prototype.bean.Client;

public class DAOFactory {

	public static DAO<Client> getClient(){
		return new ClientDAO();
	}
	
}