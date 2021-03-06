package viewController;

import java.awt.GridLayout;

import javax.swing.*;

import model.entity.Sea;

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
	 * Constructeur principal de notre classe.
	 * @param sea : Mer
	 */
	public SeaPanel(Sea sea) {	
		super();
		this.setLayout(new GridLayout(sea.getWidth(), sea.getHeight()));
		for(int i = 0 ;i<sea.getWidth() * sea.getHeight() ; i++) {
			JButton btn = new JButton();
			btn.setSize(200,200);
			switch (sea.getType(i%sea.getWidth(),i/sea.getHeight())) {
			    case "S":
                    btn.setIcon(new ImageIcon(SeaPanel.class.getResource("/resources/sardine.png")));
                    break;
                case "R":
                    btn.setIcon(new ImageIcon(SeaPanel.class.getResource("/resources/shark.png")));
                    break;
                default:
                    btn.setIcon(new ImageIcon(SeaPanel.class.getResource("/resources/sea.png")));
                    break;
            }

            this.add(btn);
		}
	}
}
