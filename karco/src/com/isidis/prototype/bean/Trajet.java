package com.isidis.prototype.bean;

import java.util.Date;

public class Trajet {
	
	private long id;
	private float prixMax;
	private String pointDepart;
	private String pointArrive;
	private int nbPersonne;
	private String typeVehicule;
	private Date heureDepart;
	private Date margeTolere;
	
	public Trajet() { }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(float prixMax) {
		this.prixMax = prixMax;
	}
	public String getPointDepart() {
		return pointDepart;
	}
	public void setPointDepart(String pointDepart) {
		this.pointDepart = pointDepart;
	}
	public String getPointArrive() {
		return pointArrive;
	}
	public void setPointArrive(String pointArrive) {
		this.pointArrive = pointArrive;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public String getTypeVehicule() {
		return typeVehicule;
	}
	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Date getMargeTolere() {
		return margeTolere;
	}
	public void setMargeTolere(Date margeTolere) {
		this.margeTolere = margeTolere;
	}
	
	

}