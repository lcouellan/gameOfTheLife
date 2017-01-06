package model.state;

import model.entity.Fish;
import model.entity.GameOfTheLife;
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
		game.getSea().setType(fish.getcX(),fish.getcY(),fish);
		for(int i = 0; i < game.getFishList().size(); i++){
		     if (game.getFishList().get(i).getcX() == fish.getcX() && game.getFishList().get(i).getcY() == fish.getcY() && game.getFishList().get(i).toString() == "S")
		    	 game.getFishList().remove(i);
		}
	}
}
