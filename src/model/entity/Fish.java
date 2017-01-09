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
	}
	
	/**
	 * Crée une sardine à des coordonnées X et Y.
	 * 
	 * @param cX : Coordonnée X du poisson dans la mer
	 * @param cY : Coordonnée Y du poisson dans la mer
	 */
	public Fish(int cX, int cY) {
		this(1,0,true,cX,cY,"S");
	}
	
	/**
	 * Crée une sardine aux coordonnées 0,0.
	 */
	public Fish() {
		this(0,0);
	}
	
	/**
	 * Indique que le poisson est mort.
	 */
	public void isDead() {
		this.isAlive = false;
	}
	
	/**
	 * Fais bouger le poisson selon l'état que l'on lui donne en paramètre grâce à <b>StateFish</b>.
	 * @param etat : pour un requin : enfant, jeune adulte ... 
	 * @param game : jeu
	 */
	public void move(StateFish etat, GameOfTheLife game) {
		etat.move(this,game);
	}
	
	/**
	 * Donne la direction de la sardine si elle se trouve dans une des cases adjacentes au poisson.
	 * @param game : jeu
	 * @return la direction d'une sardine si elle se situe sur une case adjacente sinon "NULL".
	 */
	public String isSardineNear(GameOfTheLife game) {
		// Vérification a gauche
		if (this.getcX() != 0) {
			if(game.getSea().getType(this.getcX()-1, this.getcY()) == "S"){
				return "LEFT";
			}
		}
		if (this.getcX() < game.getSea().getWidth() - 1) {
			if(game.getSea().getType(this.getcX()+1, this.getcY()) == "S"){
				return "RIGHT";
			}
		}
		if (this.getcY() != 0) {
			if(game.getSea().getType(this.getcX(), this.getcY()-1) == "S"){
				return "TOP";
			}
		}
		if (this.getcY() < game.getSea().getHeight() - 1) {
			if(game.getSea().getType(this.getcX(), this.getcY()+1) == "S"){
				return "BOTTOM";
			}
		}
		return "NULL";
	}
	
	public String isCaseEmpty(GameOfTheLife game) {
		if (this.getcX() != 0) {
			if(game.getSea().getType(this.getcX()-1, this.getcY()) == ""){
				return "LEFT";
			}
		}
		if (this.getcX() < game.getSea().getWidth() - 1) {
			if(game.getSea().getType(this.getcX()+1, this.getcY()) == ""){
				return "RIGHT";
			}
		}
		if (this.getcY() != 0) {
			if(game.getSea().getType(this.getcX(), this.getcY()-1) == ""){
				return "TOP";
			}
		}
		if (this.getcY() < game.getSea().getHeight() - 1) {
			if(game.getSea().getType(this.getcX(), this.getcY()+1) == ""){
				return "BOTTOM";
			}
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


