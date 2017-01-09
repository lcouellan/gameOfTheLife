package model.entity;

/**
 * La classe <b>Shark</b> permet la création de nos requins qui sont des poissons.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Sardine
 * @see Fish
 */
public class Shark extends Fish{
	
	private boolean hungry = true;
	private int status = 1;

	public Shark() {
		super();
	}
	public Shark(int cX, int cY) {
		super(cX, cY);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "R";
	}
	
	/**
	 * Indique que le requin a mangé.
	 */
	public void eat() {
		this.hungry = false;
	}
	
	/**
	 * Indique que le requin a vieilli.
	 */
	public void growUp() {
		this.status += 1;
	}
	
	public boolean isHungry() {
		return this.hungry;
	}
	
	public void setHungry() {
		this.hungry = true;
	}
	
	public int getStatus() {
		return this.status;
	}

}
