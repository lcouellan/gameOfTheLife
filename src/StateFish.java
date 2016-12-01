
/**
 * La classe <b>StateFish</b> est une classe abstraite qui permet la gestion des mouvements de nos poissons selon plusieurs états.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Fish
 */
public abstract class StateFish {
	/**
	 * Fais bouger notre poisson
	 */
	public abstract void move(int coordX, int coordY);
}
