package model.state;

import model.entity.Fish;
import model.entity.GameOfTheLife;
import model.entity.Sardine;

/**
 * La classe <b>StateAdult</b> est une classe qui permet la gestion des mouvements de nos poissons avec un état "adulte".
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see StateFish
 */
public class StateAdult extends StateFish{

	@Override
	public void move(Fish fish, GameOfTheLife game) {
		// TODO Auto-generated method stub
		Sardine target = findTarget(game,fish.getcX(),fish.getcY(),2);
		int distanceX = fish.getcX() - target.getcX();
		System.out.println("Target X : "+target.getcX());
		System.out.println("Target Y : "+target.getcY());
		int distanceY = fish.getcY() - target.getcY();
		if ( distanceY == 0 ) {
			if ( distanceX == 1) {
				fish.setcX(fish.getcX() - 1);
				kill(fish,game);
			} 
			if ( distanceX == -1) {
				fish.setcX(fish.getcX() + 1);
				kill(fish,game);
			} 
		} if (distanceX == 0) {
			if (distanceY == 1) {
				fish.setcY(fish.getcY() - 1);
				kill(fish,game);
			}
			if ( distanceY == -1) {
				fish.setcY(fish.getcY() + 1);
				kill(fish,game);
			}
		}
		if ( Math.abs(distanceX) > Math.abs(distanceY)) {
			if ( distanceX > 0) {
				fish.setcX(fish.getcX() - 1);
			} else {
				fish.setcX(fish.getcX() + 1);
			}
		} else {
			if ( distanceY > 0 ) {
				fish.setcY(fish.getcY() - 1);
			} else {
				fish.setcY(fish.getcY() + 1);
			}
		}
	}
	
	public Sardine findTarget(GameOfTheLife game,int coordX, int coordY, int radius) {
		for(Sardine target : game.getSardineList()) {
			if ( (target.getcX() - coordX) + (target.getcY() - coordY) == radius) {
				System.out.println("Cible : coordX : "+target.getcX()+" coordY : "+target.getcY());
				return target;
			}
		}
		findTarget(game, coordX, coordY, radius + 1);
		return null;
	}

}
