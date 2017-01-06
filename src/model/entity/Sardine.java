package model.entity;

/**
 * La classe <b>Sardine</b> permet la création de nos sardines qui sont des poissons.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Shark
 * @see Fish
 */
public class Sardine extends Fish{

	public Sardine() {
		super();
	}
	public Sardine(int cX, int cY) {
		super(cX, cY);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "S";
	}
	
}
