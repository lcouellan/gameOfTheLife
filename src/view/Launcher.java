package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.SeaPanel;
import model.entity.GameOfTheLife;

/**
 * La classe <b>Launcher</b> est la fenêtre de lancement de notre jeu.
 * 
 * @author Raphaël Erfani, Lénaïc Couëllan
 * @version 1.0
 * @see Frame
 * @see GameOfTheLife
 * @see Sea
 */
public class Launcher extends JDialog implements ActionListener{

	JButton valid = new JButton("Valider");
	JButton quit = new JButton("Quitter");
	JTextField sharkF = new JTextField(10);
	JTextField sardineF = new JTextField(10);
	public Launcher() {
		JPanel pan ;
		Box box = Box.createVerticalBox();
		setModal(true);
		setTitle("Jeu de la vie");
		pan = new JPanel();
		pan.add(new JLabel("Nombre de requins : "));
		pan.add(sharkF);
		box.add(pan);

		pan = new JPanel();
		pan.add(new JLabel("Nombre de sardines : "));
		pan.add(sardineF);
		box.add(pan);

		pan = new JPanel();
		pan.add(valid);
		pan.add(quit);
		box.add(pan);

		add(box);

		valid.addActionListener(this);
		quit.addActionListener(this);
		pack();
		this.setLocation(600, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		//new Launcher();
		new Frame(4,6);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == valid) {
			this.dispose();
			new Frame(Integer.parseInt(sharkF.getText()),Integer.parseInt(sardineF.getText()));
		}
		if (e.getSource() == quit) {
			this.dispose();
		}
	}

}
