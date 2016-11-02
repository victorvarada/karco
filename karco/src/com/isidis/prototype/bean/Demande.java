package com.isidis.prototype.bean;

public class Demande {
	
	private Integer id;
	private Trajet trajet;
	
	public Demande(){ }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Trajet getTrajet() {
		return trajet;
	}
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
}