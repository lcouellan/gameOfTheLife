package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import model.entity.Fish;
import model.entity.GameOfTheLife;
import model.state.StateChild;
import model.state.StateTeen;
import controller.SeaPanel;

/**
 * La classe <b>Frame</b> est la fenêtre de notre interface graphique.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see SeaPanel
 * @see GameOfTheLife
 */
public class Frame extends JFrame {
	
	public Frame() {
		this.setTitle("Jeu de la vie");
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		GameOfTheLife game = new GameOfTheLife();
		game.generateLife();
		StateChild state = new StateChild();
		StateTeen state2 = new StateTeen();
		for(Fish fish: game.getFishList()) {
			System.out.println("Avant déplacement");
			System.out.println("X : " + fish.getcX() + " Y : " + fish.getcY());
			fish.move(state, game.getSea());
			System.out.println("Après déplacement");
			System.out.println("X : " + fish.getcX() + " Y : " + fish.getcY());
		}
		game.refreshAllFishes();
		SeaPanel pan = new SeaPanel(game.getSea());
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(pan,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
}
