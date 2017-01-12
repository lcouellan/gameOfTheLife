package model.state;

import model.entity.Fish;
import model.entity.GameOfTheLife;
import model.entity.Shark;

/**
 * La classe <b>StateTeen</b> est une classe qui permet la gestion des mouvements de nos requins avec un état "jeune adulte".
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see StateFish
 */
public class StateTeen extends StateFish{

	
	/**
	 * Méthode qui permet de faire un déplacement plus intelligent que celui du statut "enfant".
	 * Ce déplacement simule donc le déplacement d'un requin "jeune adulte". Ce dernier se déplace sur une case adjacente.
	 * lorsque cette dernière contient une sardine. Un requin "jeune adulte" à  donc des déplacements plus menaçant qu'un requin "enfant".
	 * Si aucune sardine ne se trouvent sur les cases adjacentes, on reste sur un mouvement aléatoire.
	 */
	public void move(Fish fish, GameOfTheLife game) {
		String direction = fish.isSardineNear(game);
		switch(direction){
		case "LEFT":
			fish.setcX(fish.getcX()-1);
			//supprimer la sardine se trouvant la avant
			break;
		case "RIGHT":
			fish.setcX(fish.getcX()+1);
			//supprimer la sardine se trouvant la avant
			break;
		case "TOP":
			fish.setcY(fish.getcY()-1);
			//supprimer la sardine se trouvant la avant
			break;
		case "BOTTOM":
			fish.setcY(fish.getcY()+1);
			//supprimer la sardine se trouvant la avant
			break;
		case "NULL":
			super.move(fish, game);
			return;
		}
		kill(fish, game);
	}
}
