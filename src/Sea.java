
/**
 * Classe <b> Sea </b> qui créer l'environnement dans lequel évoluent nos
 * poissons
 * 
 * @author Raphaël Erfani, Lénaïc Couellan
 * @version 1.0
 * @see Fish
 * @see	GameOfTheLife
 *
 */
public class Sea {

	protected int cells[][];
	protected int nbShark;
	protected int nbSardine;
	protected int WIDTH = 50;
	protected int HEIGHT = 50;
	
	/**
	 * Constructeur par défaut de Sea, sa taille est définie par défaut
	 * par les constante WIDTH et HEIGHT
	 */
	public Sea() {
		this.nbSardine = 0;
		this.nbShark = 0;
		this.cells = new int [WIDTH][HEIGHT];
	}
	
	/**
	 * Constructeur de la classe Sea ou l'on choisi la taille que
	 * l'on attribue à Sea
	 * @param nbShark Nombre de Shark présent dans Sea
	 * @param nbSardine Nombre de Sardine présent dans Sea
	 * @param width Largeur de Sea
	 * @param height Hauteur de Sea
	 *
	 */
	public Sea(int nbShark, int nbSardine, int width, int height) {
		this.nbSardine = nbSardine;
		this.nbShark = nbShark;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.cells = new int [WIDTH][HEIGHT];
	}

	public int[][] getCells() {
		return cells;
	}

	public void setCells(int[][] cells) {
		this.cells = cells;
	}

	public int getNbShark() {
		return nbShark;
	}

	public void setNbShark(int nbShark) {
		this.nbShark = nbShark;
	}

	public int getNbSardine() {
		return nbSardine;
	}

	public void setNbSardine(int nbSardine) {
		this.nbSardine = nbSardine;
	}

	public int getWidth() {
		return WIDTH;
	}

	public void setWidth(int width) {
		WIDTH = width;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void setHeight(int height) {
		HEIGHT = height;
	}
	
	
}
