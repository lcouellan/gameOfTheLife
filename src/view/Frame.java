package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
public class Frame extends JFrame implements Runnable{
	
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
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameOfTheLife game = new GameOfTheLife();
		game.generateLife();
		for(int i = 1; i < 5; i++){
            System.out.println("Tour :"+i);
            try
            {
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
        		this.remove(pan);
            	this.remove(panTurn);
               
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
		}
	}
}
