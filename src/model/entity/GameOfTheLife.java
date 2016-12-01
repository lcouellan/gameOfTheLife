package model.entity;

import java.util.*;

/**
 * Classe <b> GameOfTheLife </b> permet de régir le jeu. C'est à dire qu'elle
 * instancie une nouvelle <b> Sea </b> et précise le nombre de poissons présents
 * 
 * @author Raphaël Erfani, Lénaïc Couellan
 * @version 1.0
 * @see Fish
 * @see	Sea
 *
 */
public class GameOfTheLife {

	ArrayList<Fish> fishList = new ArrayList<Fish>();
	Sea sea;
	
	
	
	/**
	 * Génère la vie dans notre mer, crée les sardines et les requins. Les place aléatoirement dans la merde.
	 */
	public void generateLife() {
		this.sea = new Sea();
		for(int i=0;i<this.sea.getNbShark();i++) {
			Shark shark = new Shark(2,i);
			this.fishList.add(shark);
			this.sea.setType(2, i, shark);
		}
		for(int i=0;i<this.sea.getNbSardine();i++) {
			Sardine sardine = new Sardine(3,i); 
			this.fishList.add(sardine);
			this.sea.setType(3, i, sardine);
		}
	}
	
	public void refreshAllFishes() {
		try {
			this.sea = new Sea();
			for(Fish fish: fishList) {
				this.sea.setType(fish.getcX(), fish.getcY(), fish);
			}
		}catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * Méthode qui lance la simulation avec un nombre de cycles infini
	 */
	public void lancerTemps() {
		
	}
	
	/**
	 * Méthode qui lance la simulation avec un nombre de cycles défini
	 * @param nbCycles Nombre de cycles de vie
	 */
	public void lancerTemps(int nbCycles) {
		
	}
	
	public ArrayList<Fish> getFishList() {
		return fishList;
	}

	public void setFishList(ArrayList<Fish> fishList) {
		this.fishList = fishList;
	}

	public Sea getSea() {
		return sea;
	}

	public void setSea(Sea sea) {
		this.sea = sea;
	}
}
