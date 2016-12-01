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
	Sea mer;
	
	/**
	 * Constructeur par défaut du jeu
	 */
	public GameOfTheLife(ArrayList<Fish> al, Sea mer) {
		this.fishList = al;
		this.mer = mer;
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
}
