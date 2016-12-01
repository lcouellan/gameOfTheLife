package model.state;

import model.entity.Fish;

/**
 * La classe <b>StateChild</b> est une classe qui permet la gestion des mouvements de nos requins avec un état "jeune adulte".
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see StateFish
 */
public class StateTeen extends StateFish{

	@Override
	/**
	 * Méthode qui permet de faire un déplacement plus intelligent que celui du statut "enfant".
	 * Ce déplacement simule donc le déplacement d'un requin "jeune adulte". Ce dernier se déplace sur une case adjacente
	 * lorsque cette dernière contient une sardine. Un requin "jeune adulte" à donc des déplacements plus menaçant qu'un requin "enfant"
	 * Si aucunes sardine ne se trouvent sur les cases adjacentes, on reste sur un mouvement aléatoire.
	 */
	public void move(Fish fish) {
		// TODO Auto-generated method stub
		// Si les cellules adjacentes sont différentes de null, utiliser le StateChild
		// Sinon se diriger vers la case ou se trouve un poisson
			// Si c'est un requin le déplacement est impossible
			// Sinon on se déplace sur la case en mangeant la sardine
		
	}
}
