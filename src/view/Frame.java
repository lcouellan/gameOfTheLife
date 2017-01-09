package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
	public Frame() {
		this.setTitle("Jeu de la vie");
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.run();
		//game.playCycle();
		this.setVisible(true);
	}
	
	/**
	 * Lance le jeu
	 * @param args : arguments
	 */
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
	
	/**
	 * Fonction permettant de gérer les Threads et donc le temps.
	 * Crée une nouvelle instance de <b>GameOfTheLife</b>. Lance une partie sur plusieurs tours et raffraichis notre panel afin d'actualiser la mer.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameOfTheLife game = new GameOfTheLife();
		game.generateLife();
		for(int i = 1; i < 10; i++){
            System.out.println("Tour :"+i);
            try
            {
            	this.getContentPane().removeAll();
            	game.playCycle();
        		SeaPanel pan = new SeaPanel(game.getSea());
        		Panel panTurn = new Panel();
        		JLabel label = new JLabel("Tour : "+i);
        		panTurn.add(label);
        		Container cp = this.getContentPane();
        		cp.setLayout(new BorderLayout());
        		cp.add(panTurn,BorderLayout.NORTH);
        		cp.add(pan,BorderLayout.CENTER);
        		pan.repaint();
        		panTurn.repaint();
        		this.setVisible(true);
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
		}
	}
}
