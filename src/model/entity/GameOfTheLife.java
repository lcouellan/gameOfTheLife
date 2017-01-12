package model.entity;

import java.util.*;

import javax.swing.JOptionPane;

import model.state.StateAdult;
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
public class GameOfTheLife {

	ArrayList<Fish> fishList = new ArrayList<Fish>();
	Sea sea;
	
	
	
	/**
	 * Génère la vie dans notre mer, crée les sardines et les requins. Les place aléatoirement dans la mer.
	 */
	public void generateLife(int nbSharks, int nbSardines, int width, int height) {
		this.sea = new Sea(nbSharks, nbSardines, width, height);
		int compteurShark = 0,compteurSardine = 0;
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
			} else {
				compteurShark++;
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
			} else {
				compteurSardine++;
			}
		}
		if ( compteurSardine > 0 ) {
			JOptionPane jop2 = new JOptionPane();
			jop2.showMessageDialog(null, compteurSardine+" de vos sardines est / sont morte(s) née(s)\n2017-2017 Never Forget", "RIP Sardine", JOptionPane.WARNING_MESSAGE);		
		}
		if ( compteurShark > 0 ) {
			JOptionPane jop2 = new JOptionPane();
			jop2.showMessageDialog(null, compteurShark+" de vos requins est / sont mort(s) né(s)\n2017-2017 Never Forget", "RIP Sardine", JOptionPane.WARNING_MESSAGE);		
		}
	}
	
	/** 
	 * Raffraichis la mer avec la liste de nos poissons.
	 */
	public void refreshAllFishes(Sea sea) {
		try {
			this.sea = new Sea(this.sea.nbShark,this.sea.nbSardine,this.sea.width,this.sea.height);
			fishList = checkDeadFishes();
			for(Fish fish: fishList) {
				this.sea.setType(fish.getcX(), fish.getcY(), fish);
			}
		}catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * Joue un cycle de vie pour chacun de nos poissons.
	 * Les poissons se reproduisent tous les 3 tours.
	 */
	public void playCycle(){
		StateChild stateC = new StateChild();
		StateTeen stateT = new StateTeen();
		StateAdult stateA = new StateAdult();
		for(Shark shark: this.getSharkList()) {
			if (shark.getAge() % 3 == 0 && shark.getAge() > 0) {
				this.reproduire(shark);
			}
			if (shark.getStatus() == 1) {
				shark.move(stateC,this);
			} else if (shark.getStatus() == 2) {
				shark.move(stateT,this);
			} else  {
				shark.move(stateA, this);
			}
		}
		this.refreshAllFishes(this.sea);
		for(Fish sardine: this.getSardineList()) {
			if(sardine.getAge() % 3 == 0 && sardine.getAge() > 0) {
				this.reproduire(sardine);
			}
			sardine.move(stateC,this);
		}
		this.refreshAllFishes(this.sea);
	}
	
	/**
	 * Reproduction de nos poissons.
	 * @param fish : poisson
	 */
	public void reproduire(Fish fish) {
		String newBorn = fish.isCaseEmpty(this);
		switch(newBorn){
		case "LEFT":
			Fish fishL;
			if ( fish.toString() == "R") {
				fishL = new Shark(fish.getcX()-1, fish.getcY());
			} else {
				fishL = new Sardine(fish.getcX()-1,fish.getcY());
			}
			this.fishList.add(fishL);
			this.sea.setType(fishL.getcX(), fishL.getcY(), fishL);
			break;
		case "RIGHT":
			Fish fishR;
			if ( fish.toString() == "R") {
				fishR = new Shark(fish.getcX() + 1, fish.getcY());
			} else {
				fishR = new Sardine(fish.getcX() + 1,fish.getcY());
			}
			this.fishList.add(fishR);
			this.sea.setType(fishR.getcX(), fishR.getcY(), fishR);
			break;
		case "TOP":
			Fish fishT;
			if ( fish.toString() == "R") {
				fishT = new Shark(fish.getcX(), fish.getcY() - 1);
			} else {
				fishT = new Sardine(fish.getcX(),fish.getcY() - 1);
			}
			this.fishList.add(fishT);
			this.sea.setType(fishT.getcX(), fishT.getcY(), fishT);
			break;
		case "BOTTOM":
			Fish fishB;
			if ( fish.toString() == "R") {
				fishB = new Shark(fish.getcX(), fish.getcY() + 1);
			} else {
				fishB = new Sardine(fish.getcX(),fish.getcY() + 1);
			}
			this.fishList.add(fishB);
			this.sea.setType(fishB.getcX(), fishB.getcY(), fishB);
			break;
		}
	}
	
	/**
	 * Lance une instance de notre jeu de la vie.
	 * @param cycle : nombre de tours
	 */
	public void startTime(int cycle) {
		playCycle();
		growFishes(1);
		this.refreshAllFishes(this.sea);
	}
	
	/**
	 * Fais vieillir tous nos poissons et tues les requins qui n'ont pas mangé.
	 * Les sardines meurent au bout de 6 tours.
	 * Les requins meurent au bout de 6 tours sans manger et 9 tours s'ils ont réussi à se nourrir. 
	 * @param time : temps
	 */
	public void growFishes(long time) {
		for (Fish fish : this.getFishList()) {
			fish.addAge(time);
			if ( fish.getAge() == 6 && fish.toString() == "S") {
				fish.setAlive(false);
			}
		}
		for (Shark shark: this.getSharkList()) {
			if (shark.getAge() == 3) {
				shark.growUp();
			}
//			if ( fish.getAge() == 6 && fish.toString() == "R") {
//				Shark shark = (Shark) fish;
//				shark.growUp();
//			}
			if (shark.getAge() == 6) {
				if (shark.isHungry()) {
					shark.setAlive(false);
				}
				shark.setHungry();
			}
			if (shark.getAge() == 9) {
				shark.setAlive(false);
			}
		}
	}
	
	/**
	 * Vérifie s'il y'a toujours des poissons dans la mer.
	 * @return sigle selon ce qu'il reste dans la mer
	 */
	public String checkVictory() {
		if ( this.getSharkList().size() > 0 && this.getSardineList().size() == 0) {
			return "R";
		}
		else if ( this.getSharkList().size() == 0 && this.getSardineList().size() > 0) {
			return "S";
		}
		else if ( this.getSharkList().size() == 0 && this.getSardineList().size() == 0) {
			return "N";
		}
		return "";
		
	}
	
	/**
	 * Met à jour notre liste de poissons en supprimant les poissons morts.
	 * @return liste de poissons mise à jour
	 */
	public ArrayList<Fish> checkDeadFishes() {
		ArrayList<Fish> fishList = new ArrayList<Fish>();
		for(Fish fish: this.fishList) {
			if (fish.isAlive)
				fishList.add(fish);
		}
		return fishList;
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
