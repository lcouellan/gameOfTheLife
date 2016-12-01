package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.entity.Sardine;
import model.entity.Sea;
import model.entity.Shark;

/**
 * La classe <b>SeaPanel</b> est le panel principal de notre interface graphique. Il affiche la mer et les poissons.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Frame
 * @see Sea
 */
public class SeaPanel extends JPanel{
	
	/**
	 * Constructeur principal de notre classe
	 * @param sea : Mer
	 */
	public SeaPanel(Sea sea) {	
		super();
		this.setLayout(new GridLayout(sea.getWidth(), sea.getHeight()));
		for(int i = 0 ;i<sea.getWidth() * sea.getHeight() ; i++) {
			JButton btn = new JButton("" + sea.getType(i%10, i/10));
			this.add(btn);
		}
	}

}
