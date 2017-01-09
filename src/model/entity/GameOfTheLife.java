package model.entity;

import java.util.*;

import model.state.StateChild;
import model.state.StateTeen;

/**
 * Classe <b> GameOfTheLife </b> permet de régir le jeu. C'est à dire qu'elle
 * instancie une nouvelle <b> Sea </b> et précise le nombre de poissons présents
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Fish
 * @see	Sea
 *
 */
public class GameOfTheLife{

	ArrayList<Fish> fishList = new ArrayList<Fish>();
	Sea sea;
	
	
	
	/**
	 * Génère la vie dans notre mer, crée les sardines et les requins. Les place aléatoirement dans la mer.
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
	
	/** 
	 * Raffraichis la mer avec la liste de nos poissons.
	 */
	public void refreshAllFishes() {
		try {
			this.sea = new Sea();
			for(Fish fish: fishList) {
				this.sea.setType(fish.getcX(), fish.getcY(), fish);
			}
		}catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * Joue un cycle de vie pour chacun de nos poissons.
	 */
	public void playCycle(){
		StateChild state = new StateChild();
		StateTeen state2 = new StateTeen();
		for(Fish shark: this.getSharkList()) {
			shark.move(state2,this);
			shark.setAge(shark.getAge()+1);
		}
		for(Fish sardine: this.getSardineList()) {
			sardine.move(state,this);
			sardine.setAge(sardine.getAge()+1);
			// tous les 4 cycles une sardine donne naissance à une autre
			if(sardine.getAge() % 4 == 0) {
				String newBorn = sardine.isCaseEmpty(this);
				switch(newBorn){
				case "LEFT":
					Sardine newSardineL = new Sardine(sardine.getcX()-1,sardine.getcY());
					this.fishList.add(newSardineL);
					this.sea.setType(newSardineL.getcX(), newSardineL.getcY(), sardine);
					break;
				case "RIGHT":
					Sardine newSardineR = new Sardine(sardine.getcX()+1,sardine.getcY());
					this.fishList.add(newSardineR);
					this.sea.setType(newSardineR.getcX(), newSardineR.getcY(), sardine);
					break;
				case "TOP":
					Sardine newSardineT = new Sardine(sardine.getcX(),sardine.getcY()-1);
					this.fishList.add(newSardineT);
					this.sea.setType(newSardineT.getcX(), newSardineT.getcY(), sardine);
					break;
				case "BOTTOM":
					Sardine newSardineB = new Sardine(sardine.getcX(),sardine.getcY()+1);
					this.fishList.add(newSardineB);
					this.sea.setType(newSardineB.getcX(), newSardineB.getcY(), sardine);
					break;
				case "NULL":
					break;
				}
			}
		}
		this.refreshAllFishes();
	}
	
	public ArrayList<Fish> getFishList() {
		return fishList;
	}
	
	/**
	 * Crée une liste de requins à partir de notre liste de poissons.
	 * @return une liste de requins.
	 */
	public ArrayList<Shark> getSharkList() {
		ArrayList<Shark> sharkList = new ArrayList<Shark>();
		for(int i = 0; i < this.getFishList().size(); i++){
		     if (this.getFishList().get(i).toString() == "R")
		    	 sharkList.add((Shark)this.getFishList().get(i));
		}
		return sharkList;
	}
	
	/**
	 * Crée une liste de sardines à partir de notre liste de poissons.
	 * @return une liste de sardines.
	 */
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
