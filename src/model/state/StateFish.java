package model.state;
import model.entity.Fish;
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
	 * Fais bouger notre poisson
	 * @param sea 
	 */
	public abstract void move(Fish fish, Sea sea);
	
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
