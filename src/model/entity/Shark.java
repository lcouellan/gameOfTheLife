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

}
