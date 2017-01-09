package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
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
public class Launcher extends JFrame implements ActionListener{

	private final int basicW = 600, basicH = 400;
	private JPanel panParams = new JPanel();
	private JPanel panTools = new JPanel();
	private JTextField sharkF = new JTextField();
	private JTextField sardineF = new JTextField();
	private JTextField widthF = new JTextField();
	private JTextField heightF = new JTextField();
	private JLabel sharkLabel = new JLabel("Saisir le nombre de requins : ");
	private JLabel sardineLabel = new JLabel("Saisir le nombre de sardines : ");
	private JLabel widthLabel = new JLabel("Saisir la largeur de la mer : ");
	private JLabel heightLabel = new JLabel("Saisir la hauteur de la mer : ");
	
	private JButton valid = new JButton("Valider");
	private JButton quit = new JButton("Quitter");
	
	/**
	 * Crée une fenêtre de lancement du jeu de la vie
	 */
	public Launcher(){
		this.setTitle("Jeu de la vie");

		this.setMinimumSize(new Dimension(basicW, basicH));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		InitComponents();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panParams,BorderLayout.CENTER);
		this.getContentPane().add(panTools,BorderLayout.SOUTH);

		valid.addActionListener(this);
		quit.addActionListener(this);
		sharkF.addActionListener(this);
		sardineF.addActionListener(this);
		widthF.addActionListener(this);
		heightF.addActionListener(this);
		this.setVisible(true);
	}

	/**
	 * Initialise les composants de la fenêtre de lancement
	 */
	public void InitComponents(){
		//panAuthentif.setBorder(BorderFactory.createTitledBorder("Identification"));
		panParams.setPreferredSize(new Dimension(220, 60));
		sharkF.setPreferredSize(new Dimension(150, 35));
		sardineF.setPreferredSize(new Dimension(150, 35));
		widthF.setPreferredSize(new Dimension(150, 35));
		heightF.setPreferredSize(new Dimension(150, 35));
		panParams.add(sharkLabel);
		panParams.add(sharkF);
		panParams.add(sardineLabel);
		panParams.add(sardineF);
//		panParams.add(widthLabel);
//		panParams.add(widthF);
//		panParams.add(heightLabel);
//		panParams.add(heightF);
		panParams.add(valid);
		valid.setMnemonic(KeyEvent.VK_ENTER);
		panParams.add(quit);

		panParams.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();


		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;


		panParams.add(sharkLabel, gbc);


		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;


		panParams.add(sharkF, gbc);


		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = gbc.WEST;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;


		panParams.add(sardineLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;


		panParams.add(sardineF, gbc);
		
//		gbc.gridx = 0;
//		gbc.gridy = 3;
//		gbc.anchor = gbc.WEST;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
//
//		gbc.weightx = 0.5;
//		gbc.weighty = 0.5;
//
//
//		panParams.add(widthLabel, gbc);
//
//		gbc.gridx = 1;
//		gbc.gridy = 3;
//		gbc.anchor = GridBagConstraints.WEST;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
//
//		gbc.weightx = 0.5;
//		gbc.weighty = 0.5;
//
//
//		panParams.add(widthF, gbc);
//		
//		gbc.gridx = 0;
//		gbc.gridy = 4;
//		gbc.anchor = gbc.WEST;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
//
//		gbc.weightx = 0.5;
//		gbc.weighty = 0.5;
//
//
//		panParams.add(heightLabel, gbc);
//
//		gbc.gridx = 1;
//		gbc.gridy = 4;
//		gbc.anchor = gbc.WEST;
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1;
//
//		gbc.weightx = 0.5;
//		gbc.weighty = 0.5;
//
//
//		panParams.add(heightF, gbc);

		panTools.setLayout(new FlowLayout());

		panTools.add(valid);	  
		panTools.add(quit);
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
