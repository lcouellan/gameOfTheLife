package model.state;

import model.entity.Fish;
import model.entity.Sea;

/**
 * La classe <b>StateChild</b> est une classe qui permet la gestion des mouvements de nos requins avec un Ã©tat "jeune adulte".
 * 
 * @author RaphaÃ«l Erfani, LÃ©naÃ¯c CouÃ«llan
 * @version 1.0
 * @see StateFish
 */
public class StateTeen extends StateFish{

	
	/**
	 * MÃ©thode qui permet de faire un dÃ©placement plus intelligent que celui du statut "enfant".
	 * Ce dÃ©placement simule donc le dÃ©placement d'un requin "jeune adulte". Ce dernier se dÃ©place sur une case adjacente
	 * lorsque cette derniÃ¨re contient une sardine. Un requin "jeune adulte" Ã  donc des dÃ©placements plus menaÃ§ant qu'un requin "enfant"
	 * Si aucunes sardine ne se trouvent sur les cases adjacentes, on reste sur un mouvement alÃ©atoire.
	 */
	public void move(Fish fish, Sea sea) {
		if (fish.isSardineNear(sea) == "haut") {
				fish.setcY(fish.getcY()-1);
		}
		if (fish.isSardineNear(sea) == "gauche") {
				fish.setcY(fish.getcX()-1);
		}
		if (fish.isSardineNear(sea) == "bas") {
				fish.setcY(fish.getcY()+1);
		}
		if (fish.isSardineNear(sea) == "droite") {
				fish.setcY(fish.getcX()+1);
		}
	}
}
