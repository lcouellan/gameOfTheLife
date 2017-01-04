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
	public void move(Fish fish, Sea sea) {
	}
	
}
