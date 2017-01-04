package model.entity;

import model.state.StateFish;

/**
 * La classe <b>Fish</b> permet la création de nos poissons (sardines ou requins).
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Shark
 * @see Sardine
 */
public class Fish {
	protected int status;
	protected long age;
	protected boolean isAlive = true;
	protected int cX;
	protected int cY;
	protected static String TYPE;
	

	/**
	 * Constructeur de base de notre classe
	 * 
	 * @param status : 1 : enfant, 2 : ado, 3 : adulte
	 * @param age : age du poisson
	 * @param isAlive : indique si le poisson est en vie ou non
	 * @param cX : Coordonnée X du poisson dans la mer
	 * @param cY : Coordonnée Y du poisson dans la mer
	 */
	public Fish(int status, long age, boolean isAlive, int cX, int cY, String type) {
		this.status = status;
		this.age = age;
		this.isAlive = isAlive;
		this.cX = cX;
		this.cY = cY;
		this.TYPE = type;
	}
	
	/**
	 * 
	 * @param cX : Coordonnée X du poisson dans la mer
	 * @param cY : Coordonnée Y du poisson dans la mer
	 */
	public Fish(int cX, int cY) {
		this.status = 1;
		this.age = 0;
		this.isAlive = true;
		this.cX = cX;
		this.cY = cY;
	}
	
	/**
	 * Indique que le poisson est mort
	 */
	public void isDead() {
		this.isAlive = false;
	}
	
	public void move(StateFish etat, Sea sea) {
		if (this.isMovePossible(sea)){
			etat.move(this,sea);
			System.out.println(this.getStatus() + " : " +this.getcX());
			System.out.println(this.getStatus() + " : " +this.getcY());
		}
	}
	
	// On test si on est pas au bord de la mer et qu'il n'y a pas de poisson occupant la case ou l'on veut se d�placer
	public boolean isMovePossible(Sea sea) {
		// deplacement en haut
		if (this.getcY() != 0) {
			if(sea.getType(this.getcX(), this.getcY()-1) != "") {
				return true;
			}
		}
		// deplacement a gauche
		if (this.getcX() != 0){
			if (sea.getType(this.getcX()-1, this.getcY()) != ""){
				return true;
			}
		}
		// deplacement en bas
		if (this.getcX() != 9 && sea.getType(this.getcX(), this.getcY()+1) != "") {
			return true;
		}
		// deplacement a droite
		if (this.getcX() != 9 && sea.getType(this.getcX()+1, this.getcY()) != "") {
			return true;
		}
		return false;
	}
	
	// On test si il y a une sardine dans les cases adjacentes
	// Si il y en a une on retourne la direction dans laquelle elle se trouve
	public String isSardineNear(Sea sea) {
		String direction = "";
		// Si il y a une sardine en haut 
		if (this.getcY() != 0 && sea.getType(this.getcX(), this.getcY()-1) != "S") {
			direction = "haut";
		}
		// Si il y a une sardine a gauche
		if (this.getcX() != 0 && sea.getType(this.getcX()-1, this.getcY()) != "S") {
			direction = "gauche";
		}
		// Si il y a une sardine en bas
		if (this.getcX() != 9 && sea.getType(this.getcX(), this.getcY()+1) != "S") {
			direction = "bas";
		}
		// Si il y a une sardine a droite
		if (this.getcX() != 9 && sea.getType(this.getcX()+1, this.getcY()) != "S") {
			direction = "droite";
		}
		return direction;
	}
	
	public boolean targetSardine(Sea sea) {
		return false;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getcX() {
		return cX;
	}

	public void setcX(int cX) {
		this.cX = cX;
	}

	public int getcY() {
		return cY;
	}

	public void setcY(int cY) {
		this.cY = cY;
	}
	
	public String toString() {
		return "";
	}
	
	
}


