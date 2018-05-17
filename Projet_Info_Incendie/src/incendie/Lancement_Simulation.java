package incendie;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Lancement_Simulation extends Affichage {

	public static void main(String[] args) {

		JFrame f = new JFrame("Bienvenue");
		JMenuBar MenuBar = new JMenuBar();
		JMenu Commencer = new JMenu("Commencer une Partie");
		JMenuItem Feu_Normal = new JMenuItem("Avec un Feu initial");
		JMenuItem Feu_Aleatoire = new JMenuItem("Avec un Feu aléatoire");
		JMenuItem Charger = new JMenuItem("Charger une Partie");
		JMenu Partie = new JMenu("Partie");

		Feu_Normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher(initialisation());

			}
		});

		Feu_Aleatoire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher(allumerFeu_Aleatoire());
			}
		});

		Charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					afficher(charger());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}
		});
		Commencer.add(Feu_Normal);
		Commencer.add(Feu_Aleatoire);
		Partie.add(Commencer);
		Partie.add(Charger);
		MenuBar.add(Partie);
		f.add(MenuBar);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(new FlowLayout());

	}

}
