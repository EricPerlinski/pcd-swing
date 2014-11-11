package compteur;

import java.util.Observable;

import vue.vueCompteur;

public class Compteur extends Observable{
	
	/* Attributs */
	
	int borneInf;
	int borneSup;
	int nombre;
	
	/* Constructeurs */
	
	public Compteur(){
		super();
		this.borneInf = -5;
		this.borneSup = 25;
		this.nombre = 0;
	}
	
	
	public Compteur(int borneInf, int borneSup, int nombre) {
		super();
		this.borneInf = borneInf;
		this.borneSup = borneSup;
		this.nombre = nombre;
	}

	/* Getters & Setters */

	public int getBorneInf() {
		return borneInf;
	}


	public void setBorneInf(int borneInf) {
		this.borneInf = borneInf;
	}


	public int getBorneSup() {
		return borneSup;
	}


	public void setBorneSup(int borneSup) {
		this.borneSup = borneSup;
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	/* ToString */
	
	@Override
	public String toString() {
		return "Compteur [borneInf=" + borneInf + ", borneSup=" + borneSup
				+ ", nombre=" + nombre + "]";
	}
	
	/* Incrementer / Decrementer */ 
	
	public boolean compteurIncremente(){
		if(this.nombre < this.borneSup) {
			this.nombre ++;
			notifyObservers();
			return true;
		}else{
			return false;
		}
		
	}
	

	
	public boolean compteurDecremente(){
		if(this.nombre > this.borneInf) {
			this.nombre --;
			notifyObservers();
			return true;
		}else{
			return false;
		}
	}
	
	/* Changer borne inferieur / superieur */ 	
	
	public void compteurChangeBorneInf(int newBorneInf) throws Exception{
		if(newBorneInf >= this.borneSup){
			throw new BorneInfException();
		}
		this.borneInf = newBorneInf;
		if(this.nombre < this.borneInf){
			this.nombre = this.borneInf;
		}
	}
	
	public void compteurChangeBorneSup(int newBorneSup) throws Exception{
		if(newBorneSup <= this.borneInf){
			throw new BorneSupException();
		}
		this.borneSup = newBorneSup;
		if(this.nombre > this.borneSup){
			this.nombre = this.borneSup;
		}
	}


	public void addObserver(vueCompteur vc) {
		// TODO Auto-generated method stub
		
	}
	
}
	

