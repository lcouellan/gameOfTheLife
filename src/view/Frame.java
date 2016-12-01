package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import controller.SeaPanel;

public class Frame extends JFrame {
	
	public Frame() {
		this.setTitle("Test Calculatrice");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		SeaPanel pan = new SeaPanel();
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(pan,BorderLayout.CENTER);
		this.setVisible(true);
	}	 
}
