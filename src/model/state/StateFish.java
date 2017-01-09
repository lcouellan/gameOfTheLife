package model.state;
import model.entity.Fish;
import model.entity.GameOfTheLife;
import model.entity.Sea;


/**
 * La classe <b>StateFish</b> est une classe abstraite qui permet la gestion des mouvements de nos poissons selon plusieurs états.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Fish
 */
public abstract class StateFish {
	
	/**
	 * Fait bouger notre poisson.
	 * De base, crée un mouvement aléatoire selon un nombre tiré au sort et donne la direction dans laquelle va se diriger le poisson. 
	 * @param fish : poisson
	 * @param game : jeu
	 */
	public void move(Fish fish, GameOfTheLife game) {
		Sea sea = game.getSea();
		int random = (int)(Math.random() * (5-1))+1;
		// mouvement en haut
		if(random == 1) {
			if (isMovePossible(fish,sea,"TOP"))
				fish.setcY(fish.getcY()-1);
			else
				move(fish,game);
		// mouvement à droite
		} else if (random == 2) {
			if (isMovePossible(fish,sea,"RIGHT"))
				fish.setcX(fish.getcX()+1);
			else
				move(fish,game);
		// mouvement en bas
		} else if (random == 3) {
			if (isMovePossible(fish,sea,"BOTTOM"))
				fish.setcY(fish.getcY()+1);
			else
				move(fish,game);
		// mouvement à gauche
		} else if (random == 4) {
			if (isMovePossible(fish,sea,"LEFT"))
				fish.setcX(fish.getcX()-1);
			else
				move(fish,game);
		}
	}
	
	/**
	 * Détermine pour un poisson si le mouvement vers la direction donnée en paramètre est possible ou non.
	 * @param fish : poisson
	 * @param sea : mer
	 * @param direction
	 * @return booléen mouvement possible ou non.
	 */
	public boolean isMovePossible(Fish fish,Sea sea,String direction) {
		switch(direction){
		case "LEFT":
			// Si on est sur le bord gauche
			if(fish.getcX() == 0){
				return false;
			}
			break;
		case "RIGHT":
			if(fish.getcX() == sea.getWidth()-1){
				return false;
			}
			break;
		case "TOP":
			if(fish.getcY() == 0){
				return false;
			}
			break;
		case "BOTTOM":
			if(fish.getcY() == sea.getHeight()-1){
				return false;
			}
			break;
		}
		return true;
	}
	
}
