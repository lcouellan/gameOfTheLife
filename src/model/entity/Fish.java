package model.entity;

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
	 * @param cY : Coordonnée Y du poisson dans la merde
	 */
	public Fish(int status, long age, boolean isAlive, int cX, int cY) {
		this.status = status;
		this.age = age;
		this.isAlive = isAlive;
		this.cX = cX;
		this.cY = cY;
	}
	
	/**
	 * 
	 * @param cX : Coordonnée X du poisson dans la mer
	 * @param cY : Coordonnée Y du poisson dans la merde
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
	
	
}


