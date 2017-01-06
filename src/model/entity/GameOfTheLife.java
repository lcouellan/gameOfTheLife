package model.entity;

import java.util.*;

import model.state.StateChild;
import model.state.StateTeen;

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
			Boolean spawn = true;
			int coordX = rand.nextInt(this.sea.getWidth() -  1);
			int coordY = rand.nextInt(this.sea.getHeight() -  1);
			for(int j = 0; j < this.getFishList().size(); j++){
				if (this.getFishList().get(j).getcX() == coordX && this.getFishList().get(j).getcY() == coordY) {
					spawn = false;
				}
			}
			if (spawn == true) {
				Shark shark = new Shark(coordX,coordY);
				this.fishList.add(shark);
				this.sea.setType(coordX, coordY, shark);
			}
		}
		for(int i=0;i<this.sea.getNbSardine();i++) {
			Random rand = new Random();
			Boolean spawn = true;
			int coordX = rand.nextInt(this.sea.getWidth() -  1);
			int coordY = rand.nextInt(this.sea.getHeight() -  1);
			for(int j = 0; j < this.getFishList().size(); j++){
				if (this.getFishList().get(j).getcX() == coordX && this.getFishList().get(j).getcY() == coordY ) {
					spawn = false;
				}
			}
			if (spawn == true) {
				Sardine sardine = new Sardine(coordX,coordY);
				this.fishList.add(sardine);
				this.sea.setType(coordX, coordY, sardine);
			}
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
		StateTeen state2 = new StateTeen();
		for(Fish shark: this.getSharkList()) {
			shark.move(state2,this);
		}
		for(Fish sardine: this.getSardineList()) {
			sardine.move(state,this);
		}
		this.refreshAllFishes();
	}
	
	public ArrayList<Fish> getFishList() {
		return fishList;
	}
	
	public ArrayList<Shark> getSharkList() {
		ArrayList<Shark> sharkList = new ArrayList<Shark>();
		for(int i = 0; i < this.getFishList().size(); i++){
		     if (this.getFishList().get(i).toString() == "R")
		    	 sharkList.add((Shark)this.getFishList().get(i));
		}
		return sharkList;
	}

	public ArrayList<Sardine> getSardineList() {
		ArrayList<Sardine> sardineList = new ArrayList<Sardine>();
		for(int i = 0; i < this.getFishList().size(); i++){
		     if (this.getFishList().get(i).toString() == "S")
		    	 sardineList.add((Sardine)this.getFishList().get(i));
		}
		return sardineList;
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
