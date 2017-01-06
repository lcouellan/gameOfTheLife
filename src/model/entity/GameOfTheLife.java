package model.entity;

import java.awt.Panel;
import java.util.*;

import model.state.StateChild;

/**
 * Classe <b> GameOfTheLife </b> permet de rÃ©gir le jeu. C'est Ã  dire qu'elle
 * instancie une nouvelle <b> Sea </b> et prÃ©cise le nombre de poissons prÃ©sents
 * 
 * @author RaphaÃ«l Erfani, LÃ©naÃ¯c Couellan
 * @version 1.0
 * @see Fish
 * @see	Sea
 *
 */
public class GameOfTheLife{

	ArrayList<Fish> fishList = new ArrayList<Fish>();
	Sea sea;
	
	
	
	/**
	 * GÃ©nÃ¨re la vie dans notre mer, crÃ©e les sardines et les requins. Les place alÃ©atoirement dans la merde.
	 */
	public void generateLife() {
		this.sea = new Sea();
		for(int i=0;i<this.sea.getNbShark();i++) {
			Random rand = new Random();
			int width = rand.nextInt(this.sea.getWidth() -  1);
			int height = rand.nextInt(this.sea.getHeight() -  1);
			Shark shark = new Shark(width,height);
			this.fishList.add(shark);
			this.sea.setType(width, height, shark);
		}
		for(int i=0;i<this.sea.getNbSardine();i++) {
			Random rand = new Random();
			int width = rand.nextInt(this.sea.getWidth() -  1);
			int height = rand.nextInt(this.sea.getHeight() -  1);
			Sardine sardine = new Sardine(width,height); 
			this.fishList.add(sardine);
			this.sea.setType(width,height, sardine);
		}
	}
	
	public void refreshAllFishes() {
		try {
			this.sea = new Sea();
			for(Fish fish: fishList) {
				this.sea.setType(fish.getcX(), fish.getcY(), fish);
			}
		}catch(NullPointerException e) {
			
		}
	}
	
	public void playCycle(){
		StateChild state = new StateChild();
		for(Fish fish: this.getFishList()) {
			fish.move(state,this.sea);
		}
		this.refreshAllFishes();
	}
	
	public ArrayList<Fish> getFishList() {
		return fishList;
	}

	public void setFishList(ArrayList<Fish> fishList) {
		this.fishList = fishList;
	}

	public Sea getSea() {
		return sea;
	}

	public void setSea(Sea sea) {
		this.sea = sea;
	}

	
}
