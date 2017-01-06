package model.state;

import model.entity.Fish;
import model.entity.Sea;

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
	 * On se base sur un random et en fonction du résultat le déplacement se fait en haut, à droite, en bas ou à gauche.
	 * Il faut aussi faire attention bords, on ne peut pas se déplacer plus loin qu'un bord.
	 */
	public void move(Fish fish, Sea sea) {
		int random = (int)(Math.random() * (5-1))+1;
		// mouvement en haut
		if(random == 1) {
			if (isMovePossible(fish,sea,"TOP"))
				fish.setcY(fish.getcY()-1);
			else
				move(fish,sea);
		// mouvement à droite
		} else if (random == 2) {
			if (isMovePossible(fish,sea,"RIGHT"))
				fish.setcX(fish.getcX()+1);
			else
				move(fish,sea);
		// mouvement en bas
		} else if (random == 3) {
			if (isMovePossible(fish,sea,"BOTTOM"))
				fish.setcY(fish.getcY()+1);
			else
				move(fish,sea);
		// mouvement à gauche
		} else if (random == 4) {
			if (isMovePossible(fish,sea,"LEFT"))
				fish.setcX(fish.getcX()-1);
			else
				move(fish,sea);
		}
	}
}