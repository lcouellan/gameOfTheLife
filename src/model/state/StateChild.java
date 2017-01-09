package model.state;

import model.entity.Fish;
import model.entity.GameOfTheLife;

/**
 * La classe <b>StateChild</b> est une classe qui permet la gestion des mouvements de nos poissons avec un état "enfant".
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see StateFish
 */
public class StateChild extends StateFish{

	
	/**
	 * Méthode qui permet de faire un déplacement aléatoire. Ce déplacement simule donc le déplacement d'un jeune poisson.
	 * Fait appel à la fonction parent ( <b>Statefish</b> ).
	 */
	public void move(Fish fish, GameOfTheLife game) {
		super.move(fish, game);
	}
}