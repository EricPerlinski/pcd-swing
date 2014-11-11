package main;
import compteur.Compteur;
import vue.Fenetre;

public class Main {

	public static void main(String[] args) {
		Compteur c= new Compteur();
		Fenetre f = new Fenetre(c);
		c.addObserver(f);
		f.addComponentListener(f);
	}
	
}