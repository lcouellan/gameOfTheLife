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
		this(1,0,true,cX,cY,"S");
	}
	
	public Fish() {
		this(0,0);
	}
	
	/**
	 * Indique que le poisson est mort
	 */
	public void isDead() {
		this.isAlive = false;
	}
	
	public void move(StateFish etat, Sea sea) {
		etat.move(this,sea);
	}
	
	// On test si il y a une sardine dans les cases adjacentes
	// Si il y en a une on retourne la direction dans laquelle elle se trouve
	public String isSardineNear(Sea sea) {
		// Vérification a gauche
		if(sea.getType(this.getcX()-1, this.getcY()) == "S"){
			return "LEFT";
		}
		if(sea.getType(this.getcX()+1, this.getcY()) == "S"){
			return "RIGHT";
		}
		if(sea.getType(this.getcX(), this.getcY()-1) == "S"){
			return "TOP";
		}
		if(sea.getType(this.getcX(), this.getcY()+1) == "S"){
			return "BOTTOM";
		}
		return "NULL";
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


