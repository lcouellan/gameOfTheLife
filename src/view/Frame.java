package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.entity.GameOfTheLife;
import controller.SeaPanel;

/**
 * La classe <b>Frame</b> est la fenêtre de notre interface graphique.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see SeaPanel
 * @see GameOfTheLife
 */
public class Frame extends JFrame implements Runnable{
	
	/**
	 * Constructeur de notre classe, crée une fenêtre contenant notre panel <b>SeaPanel</b>.
	 */
	public Frame(int nbSharks, int nbSardines) {
		this.setTitle("Jeu de la vie");
		this.setSize(950, 950);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.run(15, nbSharks, nbSardines);
		this.setVisible(true);
	}
	
	public void displayLayout(GameOfTheLife game, int compteur) {
		this.getContentPane().removeAll();
    	game.startTime(compteur);
		SeaPanel pan = new SeaPanel(game.getSea());
		Panel panTurn = new Panel();
		JLabel label = new JLabel("Tour : " + compteur);
		panTurn.add(label);
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(panTurn,BorderLayout.NORTH);
		cp.add(pan,BorderLayout.CENTER);
		pan.repaint();
		panTurn.repaint();
		this.setVisible(true);
	}
	
	public boolean end(GameOfTheLife game) {
		if (game.checkVictory() == "R") {
        	JOptionPane jop1 = new JOptionPane();
        	jop1.showMessageDialog(null, "Les requins ont mangés toutes les sardines !", "Victoire des requins", JOptionPane.INFORMATION_MESSAGE);
        	return true;
		} else if (game.checkVictory() == "S") {
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Les sardines ont survécues aux requins !", "Victoire des sardines", JOptionPane.INFORMATION_MESSAGE);
            return true;
		} else if (game.checkVictory() == "N") {
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Tous les poissons sont décédés ! :'(", "Match nul", JOptionPane.INFORMATION_MESSAGE);
            return true;
		}
		return false;
	}
	
	/**
	 * Fonction permettant de gérer les Threads et donc le temps.
	 * Crée une nouvelle instance de <b>GameOfTheLife</b>. Lance une partie sur plusieurs tours et raffraichis notre panel afin d'actualiser la mer.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	public void run(int cycles, int nbSharks, int nbSardines) {
		// TODO Auto-generated method stub
		GameOfTheLife game = new GameOfTheLife();
		game.generateLife(nbSharks, nbSardines);
		for (int i = 0; i < cycles; i++) {
            System.out.println("Tour :" + i);
            try
            {
            	displayLayout(game,i);
                Thread.sleep(500);
                if (end(game))
                	break;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
		}
	}
}
