package incendie;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author  mazeranpaul_virolanjonathan
 *
 */


public class Affichage extends Grille {

	public static int nb_tours = 0; // Correspond au nombre tour;
	public static int compteur = 0; // Correspond au nombre de fois 
	
	/**
	 *  La méthode affichage permet d'afficher notre grille composé des différentes cases et de notre pompier.
	 * @param Grille : Correspond à un couple Map<Case,JButton> composé de toutes les cases de l'interface.
	 * @return List<Case> : Renvoie une liste avec toutes les cases qui ont été modifié lors de la partie (Nécessaire pour la sauvegarde).
	 */
	public static List<Case> afficher(Map<Case, JButton> Grille) {
		
		
		/**
		 * Importation des Images et modifications de celle-ci pour qu'elles ont la même image pour qu'elle soient tous de même taille.
		 */
		ImageIcon Cendre = new ImageIcon("Images/Java2d_cendre.jpg");
		ImageIcon CendreV2 = new ImageIcon(Cendre.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Maison_Feu = new ImageIcon("Images/Java2d_Maison_en_feu.jpg");
		ImageIcon Maison_FeuV2 = new ImageIcon(Maison_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Forêt_Feu = new ImageIcon("Images/Java2d_arbre_en_feu.jpeg");
		ImageIcon Forêt_FeuV2 = new ImageIcon(Forêt_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Plaine_Feu = new ImageIcon("Images/Java2d_Plaine_en_feu.jpg");
		ImageIcon Plaine_FeuV2 = new ImageIcon(Plaine_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Eau = new ImageIcon("Images/Java2d_eau");
		ImageIcon EauV2 = new ImageIcon(Eau.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Pompier_Plaine = new ImageIcon("Images/Java2d_Plaine_pompier.jpg");
		ImageIcon Pompier_PlaineV2 = new ImageIcon(Pompier_Plaine.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Pompier_Maison = new ImageIcon("Images/Java2d_Maison_pompier.jpg");
		ImageIcon Pompier_MaisonV2 = new ImageIcon(Pompier_Maison.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Pompier_Forêt = new ImageIcon("Images/Java2d_arbre_pompier.jpg");
		ImageIcon Pompier_ForêtV2 = new ImageIcon(Pompier_Forêt.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Pompier_Feu_Plaine = new ImageIcon("Images/Java2d_Plaine_en_feu_pompier.jpg");
		ImageIcon Pompier_Feu_PlaineV2 = new ImageIcon(Pompier_Feu_Plaine.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Pompier_Feu_Maison = new ImageIcon("Images/Java2d_Maison_en_feu_pompier.jpg");
		ImageIcon Pompier_Feu_MaisonV2 = new ImageIcon(Pompier_Feu_Maison.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Pompier_Feu_Forêt = new ImageIcon("Images/Java2d_arbre_en_feu_pompier.jpg");
		ImageIcon Pompier_Feu_ForêtV2 = new ImageIcon(Pompier_Feu_Forêt.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		
		/**
		 * Création de notre pompier.
		 */
		Pompier Pompier1 = new Pompier(4,6);
		/*
		Pompier Pompier2 = new Pompier(4,6);
		Pompier Pompier3 = new Pompier(4,6);
		Pompier Pompier4 = new Pompier(4,6);
		*/
		
		/**
		 * Création de notre interface.
		 */
		JFrame f = new JFrame("Grille");
		f.setSize(500,500);
		f.setFocusable(true);
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		f.setLayout(gb);
		
		/**
		 * Création de ma fenêtre où apparaitra les informations.
		 */
		JFrame l = new JFrame("Informations");
		l.setSize(500,1000);
		l.setLocation(1000, 0);
		JPanel Panel = new JPanel();
		Panel.setLayout(new FlowLayout(FlowLayout.CENTER,900,5));
		l.setFocusable(true);	
		
		/**
		 * Création d'une List<Case> composée uniquement des Cases (en fonction de la grille en argument).
		 */
		List<Case> Case = new ArrayList<>();
		for (Case c : Grille.keySet()) {
			Case.add(c);
		}
		
		
		/**
		 * Création d'une List<JButton> composée uniquement des Boutons (en fonction de la grille en argument).
		 */
		List<JButton> Bouton = new ArrayList<>();
		for (JButton b : Grille.values()) {
			Bouton.add(b);
		}
		
		/**
		 * Création d'un Couple Map<Case,JButton> car ce celui-ci sera modifié à chaque tour.
		 */
		Map<Case, JButton> Couple = Grille;
		List<Case> toto = new ArrayList<>();
		for (Case c : Couple.keySet()){
			toto.add(c);
		}
		
		/**
		 * Création d'une List<JButton> composée uniquement des Boutons avec comme image les différents type de case en feu.
		 */
		List<JButton> Bouton_Feu = new ArrayList<>();
		for (Case c : Case) {	
			if (c.nature_case == NatureCase.FORET) {
				JButton Bouton_Forêt_Feu = new JButton(Forêt_FeuV2);
				Bouton_Feu.add(Bouton_Forêt_Feu);
			}
			if (c.nature_case == NatureCase.MAISON) {
				JButton Bouton_Maison_Feu = new JButton(Maison_FeuV2);
				Bouton_Feu.add(Bouton_Maison_Feu);
			}
			if (c.nature_case == NatureCase.PLAINE) {
				JButton Bouton_Plaine_Feu = new JButton(Plaine_FeuV2);
				Bouton_Feu.add(Bouton_Plaine_Feu);
			}
			
			if (c.nature_case == NatureCase.EAU) {
				Bouton_Feu.add(new JButton(EauV2));
			}
		}
		
		/**
		 * Création d'une List<JButton> composée uniquement des Boutons avec comme image les différents type de case avec le pompier.
		 */
		List<JButton> Bouton_Case_Pompier = new ArrayList<>();
		for (Case c : Case){
			if (c.nature_case == NatureCase.FORET) {
				JButton Bouton_Pompier_Forêt = new JButton(Pompier_ForêtV2);
				Bouton_Case_Pompier.add(Bouton_Pompier_Forêt);
			}
			if (c.nature_case == NatureCase.MAISON) {
				JButton Bouton_Pompier_Maison = new JButton(Pompier_MaisonV2);
				Bouton_Case_Pompier.add(Bouton_Pompier_Maison);
			}
			if (c.nature_case == NatureCase.PLAINE) {
				JButton Bouton_Pompier_Plaine = new JButton(Pompier_PlaineV2);
				Bouton_Case_Pompier.add(Bouton_Pompier_Plaine);
			}
			
			if (c.nature_case == NatureCase.EAU) {
				Bouton_Case_Pompier.add(new JButton(EauV2));
			}
		}
		/**
		 * Création d'une List<JButton> composée uniquement des Boutons avec comme image les différents type de case en feu et en présence d'un pompier.
		 */
		List<JButton> Bouton_Case_Feu_Pompier = new ArrayList<>();
		for (Case c: Case){
			if (c.nature_case == NatureCase.FORET) {
				JButton Bouton_Pompier_Forêt_Feu = new JButton(Pompier_Feu_ForêtV2);
				Bouton_Case_Feu_Pompier.add(Bouton_Pompier_Forêt_Feu);
			}
			if (c.nature_case == NatureCase.MAISON) {
				JButton Bouton_Pompier_Maison_Feu = new JButton(Pompier_Feu_MaisonV2);
				Bouton_Case_Feu_Pompier.add(Bouton_Pompier_Maison_Feu);
			}
			if (c.nature_case == NatureCase.PLAINE) {
				JButton Bouton_Pompier_Plaine_Feu = new JButton(Pompier_Feu_PlaineV2);
				Bouton_Case_Feu_Pompier.add(Bouton_Pompier_Plaine_Feu);
			}
			
			if (c.nature_case == NatureCase.EAU) {
				Bouton_Case_Feu_Pompier.add(new JButton(EauV2));
			}
		}
		
		/**
		 * Création d'une List<Pompier> de pompier (ici qu'un seul pompier car le programme ne fonctionne que pour un seul pompier).
		 */
		List<Pompier> Pompiers = new ArrayList<>();
		Pompiers.add(Pompier1);
		/*
		Pompiers.add(Pompier2);
		Pompiers.add(Pompier3);
		Pompiers.add(Pompier4);
		*/
		
		/**
		 * Création de l'action déplacement du pompier lorsque l'on appuie sur une des touches directionnelles.
		 */
		KeyListener Deplacement = new KeyListener() {
			
			public int deplacement;	
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if ((key == KeyEvent.VK_LEFT)) { // déplacement à droite;
					int j = Pompier1.colonne_j - 1;
					int i = Pompier1.ligne_i;
					for (int r = 0; r < toto.size(); r++){
						if (toto.get(r).getCase(j, i)){
							if (toto.get(r).nature_case != NatureCase.EAU){
							for (int w = 0; w < toto.size(); w++){
								if (toto.get(w).getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
									toto.get(w).presence_pompier = false;
									if (toto.get(w).etat_case == EtatCase.INTACTE ){
										f.remove(Bouton_Case_Pompier.get(w));
										gbc.gridx = Pompier1.colonne_j;
										gbc.gridy = Pompier1.ligne_i;
										f.add(Bouton.get(w), gbc);
										f.repaint();
										f.revalidate();
									}
									if (toto.get(w).etat_case == EtatCase.FEU){
										f.remove(Bouton_Case_Feu_Pompier.get(w));
										gbc.gridx = Pompier1.colonne_j;
										gbc.gridy = Pompier1.ligne_i;
										f.add(Bouton_Feu.get(w), gbc);
										f.repaint();
										f.revalidate();
									}
								}
							}
							
							Pompier1.deplacement(i,j);
							Panel.add(new JLabel("Le pompier se situe maintenant à la case " + Pompier1.getPosition().toString() + "."));
							int o = 0;
							for (Case c : toto){
								if (c.getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
									c.presence_pompier = true;
									if (c.etat_case == EtatCase.INTACTE){
										f.remove(Bouton.get(o));
										gbc.gridx = c.colonne_j;
										gbc.gridy = c.ligne_i;
										f.add(Bouton_Case_Pompier.get(o),gbc);
										f.repaint();
										f.revalidate();
									}
									if (c.etat_case == EtatCase.FEU){
										f.remove(Bouton_Feu.get(o));
										gbc.gridx = c.colonne_j;
										gbc.gridy = c.ligne_i;
										f.add(Bouton_Case_Feu_Pompier.get(o),gbc);
										f.repaint();
										f.revalidate();
									}
								}
								o++;
							}
							}
							else {
								JOptionPane.showMessageDialog(null, "Le pompier ne sait pas nager !", "Erreur",JOptionPane.ERROR_MESSAGE );
							}
						}
					}
					deplacement = 1;
				}
						if ((key == KeyEvent.VK_RIGHT)) {
							int j = Pompier1.colonne_j + 1;
							int i = Pompier1.ligne_i;
							for (int r = 0; r < toto.size(); r++){
								if (toto.get(r).getCase(j, i)){
									if (toto.get(r).nature_case != NatureCase.EAU){
									
									for (int w = 0; w < toto.size(); w++){
										if (toto.get(w).getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
											toto.get(w).presence_pompier = false;
											if (toto.get(w).etat_case == EtatCase.INTACTE ){
												f.remove(Bouton_Case_Pompier.get(w));
												gbc.gridx = Pompier1.colonne_j;
												gbc.gridy = Pompier1.ligne_i;
												f.add(Bouton.get(w), gbc);
												f.repaint();
												f.revalidate();
											}
											if (toto.get(w).etat_case == EtatCase.FEU){
												f.remove(Bouton_Case_Feu_Pompier.get(w));
												gbc.gridx = Pompier1.colonne_j;
												gbc.gridy = Pompier1.ligne_i;
												f.add(Bouton_Feu.get(w), gbc);
												f.repaint();
												f.revalidate();
											}
										}
									}
									
									Pompier1.deplacement(i,j);
									Panel.add(new JLabel("Le pompier se situe maintenant à la case " + Pompier1.getPosition().toString() + "."));
									int o = 0;
									for (Case c : toto){
										if (c.getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
											c.presence_pompier = true;
											if (c.etat_case == EtatCase.INTACTE){
												f.remove(Bouton.get(o));
												gbc.gridx = c.colonne_j;
												gbc.gridy = c.ligne_i;
												f.add(Bouton_Case_Pompier.get(o),gbc);
												f.repaint();
												f.revalidate();
											}
											if (c.etat_case == EtatCase.FEU){
												f.remove(Bouton_Feu.get(o));
												gbc.gridx = c.colonne_j;
												gbc.gridy = c.ligne_i;
												f.add(Bouton_Case_Feu_Pompier.get(o),gbc);
												f.repaint();
												f.revalidate();
											}
										}
										o++;
									}
									}
									else {
										JOptionPane.showMessageDialog(null, "Le pompier ne sait pas nager !", "Erreur",JOptionPane.ERROR_MESSAGE );
									}
								}
							}
							deplacement = 1;
						}
						if ((key == KeyEvent.VK_UP)) {
							int j = Pompier1.colonne_j;
							int i = Pompier1.ligne_i - 1;
							for (int r = 0; r < toto.size(); r++){
								if (toto.get(r).getCase(j, i)){
									if (toto.get(r).nature_case != NatureCase.EAU){
									
									for (int w = 0; w < toto.size(); w++){
										if (toto.get(w).getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
											toto.get(w).presence_pompier = false;
											if (toto.get(w).etat_case == EtatCase.INTACTE ){
												f.remove(Bouton_Case_Pompier.get(w));
												gbc.gridx = Pompier1.colonne_j;
												gbc.gridy = Pompier1.ligne_i;
												f.add(Bouton.get(w), gbc);
												f.repaint();
												f.revalidate();
											}
											if (toto.get(w).etat_case == EtatCase.FEU){
												f.remove(Bouton_Case_Feu_Pompier.get(w));
												gbc.gridx = Pompier1.colonne_j;
												gbc.gridy = Pompier1.ligne_i;
												f.add(Bouton_Feu.get(w), gbc);
												f.repaint();
												f.revalidate();
											}
										}
									}
									Pompier1.deplacement(i,j);
									Panel.add(new JLabel("Le pompier se situe maintenant à la case " + Pompier1.getPosition().toString() + "."));
									int o = 0;
									for (Case c : toto){
										if (c.getCase(Pompier1.colonne_j,Pompier1.ligne_i)){
											c.presence_pompier = true;
											if (c.etat_case == EtatCase.INTACTE){
												f.remove(Bouton.get(o));
												gbc.gridx = c.colonne_j;
												gbc.gridy = c.ligne_i;
												f.add(Bouton_Case_Pompier.get(o),gbc);
												f.repaint();
												f.revalidate();
											}
											if (c.etat_case == EtatCase.FEU){
												f.remove(Bouton_Feu.get(o));
												gbc.gridx = c.colonne_j;
												gbc.gridy = c.ligne_i;
												f.add(Bouton_Case_Feu_Pompier.get(o),gbc);
												f.repaint();
												f.revalidate();
											}
										}
										o++;
									}
									}
									else {
										JOptionPane.showMessageDialog(null, "Le pompier ne sait pas nager !", "Erreur",JOptionPane.ERROR_MESSAGE );
									}
								}
							}
							deplacement = 1;
						}
					if ((key == KeyEvent.VK_DOWN)) {
						int j = Pompier1.colonne_j;
						int i = Pompier1.ligne_i + 1;
						for (int r = 0; r < toto.size(); r++){
							if (toto.get(r).getCase(j, i)){
								if (toto.get(r).nature_case != NatureCase.EAU){
								
								
									for (int w = 0; w < toto.size(); w++){
										if (toto.get(w).getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
											toto.get(w).presence_pompier = false;
											if (toto.get(w).etat_case == EtatCase.INTACTE ){
												f.remove(Bouton_Case_Pompier.get(w));
												gbc.gridx = Pompier1.colonne_j;
												gbc.gridy = Pompier1.ligne_i;
												f.add(Bouton.get(w), gbc);
												f.repaint();
												f.revalidate();
											}
											if (toto.get(w).etat_case == EtatCase.FEU){
												f.remove(Bouton_Case_Feu_Pompier.get(w));
												gbc.gridx = Pompier1.colonne_j;
												gbc.gridy = Pompier1.ligne_i;
												f.add(Bouton_Feu.get(w), gbc);
												f.repaint();
												f.revalidate();
											}
										}
									}
								
									Pompier1.deplacement(i,j);
									Panel.add(new JLabel("Le pompier se situe maintenant à la case " + Pompier1.getPosition().toString() + "."));
								
								int o = 0;
								for (Case c : toto){
									if (c.getCase(Pompier1.colonne_j, Pompier1.ligne_i)){
										c.presence_pompier = true;
										if (c.etat_case == EtatCase.INTACTE){
											f.remove(Bouton.get(o));
											gbc.gridx = c.colonne_j;
											gbc.gridy = c.ligne_i;
											f.add(Bouton_Case_Pompier.get(o),gbc);
											f.repaint();
											f.revalidate();
										}
										if (c.etat_case == EtatCase.FEU){
											f.remove(Bouton_Feu.get(o));
											gbc.gridx = c.colonne_j;
											gbc.gridy = c.ligne_i;
											f.add(Bouton_Case_Feu_Pompier.get(o),gbc);
											f.repaint();
											f.revalidate();
										}
									}
									o++;
								}
								}
								else {
									JOptionPane.showMessageDialog(null, "Le pompier ne sait pas nager !", "Erreur",JOptionPane.ERROR_MESSAGE );
								}
							}
						}
						deplacement = 1;
					}
				
				if (deplacement == 1){
				Timer Tour = new Timer();
					TimerTask Action = new TimerTask() {
										
						public void run() {
								
							nb_tours++;
							Panel.add(new JLabel("Tour " + nb_tours));
							int r = 0;	
							
							List<Case> toto = new ArrayList<>();
							for (Case c : Couple.keySet()){
								toto.add(c);
							}
							
							int nb_maison_cendre = 0;
							int nb_case_feu = 0;
							
							
							for (Case c : toto) {
								if (c.nature_case == NatureCase.FORET) {
									Forêt Forêt = (Forêt) c;
									int x = Forêt.getPropagation();
									if (Forêt.etat_case == EtatCase.FEU) {
										for (int i = 0; i < Forêt.getPropagationIncendie(x,toto).size(); i++){
										int colonne = Forêt.getPropagationIncendie(x,toto).get(i).get(0);
										int ligne = Forêt.getPropagationIncendie(x,toto).get(i).get(1);
										int k = 0;
										for (Case d : toto) {
											if (d.getCase(colonne,ligne) == true) {
												if (d.etat_case == EtatCase.INTACTE && d.nature_case != NatureCase.EAU) {
													d.intensite = 1;
													d.etat_case = EtatCase.FEU;
													f.remove(Bouton.get(k));	
													gbc.gridx = d.colonne_j;
													gbc.gridy = d.ligne_i;
													f.add(Bouton_Feu.get(k),gbc);
													Couple.put(d,Bouton_Feu.get(k));
													f.repaint();
													f.revalidate();
													Panel.add(new JLabel("La " + d.nature_case.toString() + " "  + d.getPosition().toString() + " a pris feu."));
												}
											}
											
										}
										k++;
									}
									}
									Forêt.gestion_intensite();
									if (Forêt.etat_case == EtatCase.FEU){
										Panel.add(new JLabel("La Forêt " + Forêt.getPosition().toString() + " a pour intensité " + Forêt.intensite + "."));	
										
									}
									
									if (Forêt.etat_case == EtatCase.CARBONISE) {
										
										JLabel Cendre = new JLabel(CendreV2);
										f.remove(Couple.get(Forêt));
										gbc.gridx = Forêt.getPosition().get(0);
										gbc.gridy = Forêt.getPosition().get(1);
										f.add(Cendre,gbc);
										f.repaint();
										f.revalidate();
										Panel.add(new JLabel("La Forêt " + Forêt.getPosition().toString() + " est en cendre !"));
									}
															
								}
								
								if (c.nature_case == NatureCase.PLAINE) {
									Plaine Plaine = (Plaine) c;
									
									if (Plaine.etat_case == EtatCase.FEU) {
										int x = Plaine.getPropagation();
										if ( x == 0){
										}
										else{
											for (int i = 0; i < Plaine.getPropagationIncendie(x,toto).size(); i++){
												int colonne = Plaine.getPropagationIncendie(x,toto).get(i).get(0);
												int ligne = Plaine.getPropagationIncendie(x,toto).get(i).get(1);
												int k = 0;
												for (Case d : toto) {
													if (d.getCase(colonne,ligne) == true) {
														if (d.etat_case == EtatCase.INTACTE && d.nature_case != NatureCase.EAU) {
															d.intensite = 1;
															d.etat_case = EtatCase.FEU;
															f.remove(Bouton.get(k));	
															gbc.gridx = d.colonne_j;
															gbc.gridy = d.ligne_i;
															f.add(Bouton_Feu.get(k),gbc);
															Couple.put(d,Bouton_Feu.get(k));
															f.repaint();
															f.revalidate();
															Panel.add(new JLabel("La " + d.nature_case.toString() + " "  + d.getPosition().toString() + " a pris feu."));
												
														}
													}
													k++;
												}
											}
										}
									}
									Plaine.gestion_intensite();
									if (Plaine.etat_case == EtatCase.FEU){
										Panel.add(new JLabel("La Plaine " + Plaine.getPosition().toString() + " a pour intensité " + Plaine.intensite + "."));	
									}
									if (Plaine.etat_case == EtatCase.CARBONISE) {
										
											JLabel Cendre = new JLabel(CendreV2);
											f.remove(Bouton_Feu.get(r));
											gbc.gridx = Plaine.getPosition().get(0);
											gbc.gridy = Plaine.getPosition().get(1);
											f.add(Cendre,gbc);
											f.repaint();
											f.revalidate();
											Panel.add(new JLabel("La Plaine " + Plaine.getPosition().toString() + " est en cendre !"));
										
									}
								}
								
								if (c.nature_case == NatureCase.MAISON) {
									Maison Maison = (Maison) c;
									int x = Maison.getPropagation();
									if ( x == 0){
									}
									else{
									if (Maison.etat_case == EtatCase.FEU) {
										for (int i = 0; i < Maison.getPropagationIncendie(x,toto).size(); i++){
											
											int colonne = Maison.getPropagationIncendie(x,toto).get(i).get(0);
											int ligne = Maison.getPropagationIncendie(x,toto).get(i).get(1);
											int k = 0;
											for (Case d : toto) {
												if (d.getCase(colonne,ligne) == true) {
													if (d.etat_case == EtatCase.INTACTE && d.nature_case != NatureCase.EAU) {
														d.intensite = 1;
														d.etat_case = EtatCase.FEU;
														f.remove(Bouton.get(k));	
														gbc.gridx = d.colonne_j;
														gbc.gridy = d.ligne_i;
														f.add(Bouton_Feu.get(k),gbc);
														Couple.put(d,Bouton_Feu.get(k));
														f.repaint();
														f.revalidate();
														Panel.add(new JLabel("La " + d.nature_case.toString() + " "  + d.getPosition().toString() + " a pris feu."));
											
													}
												}
												k++;
											}
										}
									}
									}
									Maison.gestion_intensite();
									if (Maison.etat_case == EtatCase.FEU){
										Panel.add(new JLabel("La Maison " + Maison.getPosition().toString() + " a pour intensité " + Maison.intensite + "."));	
									}
									
									if (Maison.etat_case == EtatCase.CARBONISE) {
										
										JLabel Cendre = new JLabel(CendreV2);
										f.remove(Bouton_Feu.get(r));
										gbc.gridx = Maison.getPosition().get(0);
										gbc.gridy = Maison.getPosition().get(1);
										f.add(Cendre,gbc);
										f.repaint();
										f.revalidate();
										Panel.add(new JLabel("La Maison " + Maison.getPosition().toString() + " est en cendre !"));
										nb_maison_cendre++;
									}
								}
								r++;			
							}					
							for (Case g : toto){
								if (g.etat_case == EtatCase.FEU){
									nb_case_feu++;
								}

							}
							Panel.add(new JLabel("Il reste " + nb_case_feu + " case(s) encore en feu."));
							Panel.add(new JLabel("Il y a  " + nb_maison_cendre + " maison(s) en cendre."));
							if (nb_maison_cendre == 5){
								JOptionPane.showMessageDialog(null, "Il y a 5 maisons ou plus en cendre" + "\n " +  "Vous avez donc perdu la partie ! " + "\n" + "Dommage !", "Partie Perdu",JOptionPane.PLAIN_MESSAGE );
								Tour.cancel();
							}
							if (nb_case_feu == 0){
								JOptionPane.showMessageDialog(null, "Il n'y a plus aucun feu active" + "\n" + "Vous avez donc gagné !" + "\n" + "Bravo !", "Partie Gagné",JOptionPane.PLAIN_MESSAGE );
								Tour.cancel();
							}
							l.add(Panel);
							l.repaint();
							l.revalidate();
							
							f.requestFocus();
						}
					};
				Tour.schedule(Action,1500);
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}

			public void keyTyped(KeyEvent e) {
				
			}
			
		};
		/**
		 * Pour les boutons qui ne sont pas des images, si le joueur appuie sur le bouton rien ne se passera.
		 * Mais pour les boutons qui sont en feu, le joueur pourra faire baisser l'intensité de la case de 2.
		 */
		int y = 0;
		for (Case c : toto){
			Bouton.get(y).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (Pompier1.eteindreFeu(c) == false) {
						Panel.add(new JLabel("Cette case n'est pas en feu"));
						f.requestFocus();
					}
				}
				
			});
			Bouton_Feu.get(y).addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					if (Pompier1.eteindreFeu(c) == true) {
						if (c.getIntensite() == 0){
							c.etat_case = EtatCase.INTACTE;
							for (int w = 0; w < toto.size(); w++ ){
								if (toto.get(w).getCase(c.colonne_j, c.ligne_i) == true){
									f.remove(Bouton_Feu.get(w));
									gbc.gridx = c.colonne_j;
									gbc.gridy = c.ligne_i;
									f.add(Bouton.get(w),gbc);
									f.repaint();
									f.revalidate();
								}
							}
							
						}
						Panel.add(new JLabel("La case situé en " + c.getPosition().toString() + " a pour nouvelle intensité " + c.intensite));
						compteur++;

					}
					else {
						Panel.add(new JLabel("Cette Case n'est pas adjacent aux pompiers"));
					}
					l.add(Panel);
					l.repaint();
					l.revalidate();
				
					if (compteur == 3){
					Timer Tour = new Timer();
					TimerTask Action = new TimerTask() {
											
						public void run() {
								
							nb_tours++;
							Panel.add(new JLabel("Tour " + nb_tours));
							
							int r = 0;	
							
							List<Case> toto = new ArrayList<>();
							for (Case c : Couple.keySet()){
								toto.add(c);
							}
							
							int nb_maison_cendre = 0;
							int nb_case_feu = 0;
							
							
							for (Case c : toto) {
								if (c.nature_case == NatureCase.FORET) {
									Forêt Forêt = (Forêt) c;
									int x = Forêt.getPropagation();
									if (x == 0){
									}
									else{
									if (Forêt.etat_case == EtatCase.FEU) {
										for (int i = 0; i < Forêt.getPropagationIncendie(x,toto).size(); i++){
										int colonne = Forêt.getPropagationIncendie(x,toto).get(i).get(0);
										int ligne = Forêt.getPropagationIncendie(x,toto).get(i).get(1);
										int k = 0;
										for (Case d : toto) {
											if (d.getCase(colonne,ligne) == true) {
												if (d.etat_case == EtatCase.INTACTE && d.nature_case != NatureCase.EAU) {
													d.intensite = 1;
													d.etat_case = EtatCase.FEU;
													f.remove(Bouton.get(k));	
													gbc.gridx = d.colonne_j;
													gbc.gridy = d.ligne_i;
													f.add(Bouton_Feu.get(k),gbc);
													Couple.put(d,Bouton_Feu.get(k));
													f.repaint();
													f.revalidate();
													Panel.add(new JLabel("La " + d.nature_case.toString() + " "  + d.getPosition().toString() + " a pris feu."));
												}
											}
											
										}
										k++;
									}
									}
								}
									Forêt.gestion_intensite();
									if (Forêt.etat_case == EtatCase.FEU){
										Panel.add(new JLabel("La Forêt " + Forêt.getPosition().toString() + " a pour intensité " + Forêt.intensite));						
									}
									
									if (Forêt.etat_case == EtatCase.CARBONISE) {
										JLabel Cendre = new JLabel(CendreV2);
										f.remove(Couple.get(Forêt));
										gbc.gridx = Forêt.getPosition().get(0);
										gbc.gridy = Forêt.getPosition().get(1);
										f.add(Cendre,gbc);
										f.repaint();
										f.revalidate();
										Panel.add(new JLabel("La Forêt " + Forêt.getPosition().toString() + " est en cendre."));
									}
															
								}
								
								if (c.nature_case == NatureCase.PLAINE) {
									Plaine Plaine = (Plaine) c;
									
									if (Plaine.etat_case == EtatCase.FEU) {
										int x = Plaine.getPropagation();
										if ( x == 0){
										}
										else{
											for (int i = 0; i < Plaine.getPropagationIncendie(x,toto).size(); i++){
												int colonne = Plaine.getPropagationIncendie(x,toto).get(i).get(0);
												int ligne = Plaine.getPropagationIncendie(x,toto).get(i).get(1);
												int k = 0;
												for (Case d : toto) {
													if (d.getCase(colonne,ligne) == true) {
														if (d.etat_case == EtatCase.INTACTE && d.nature_case != NatureCase.EAU) {
															d.intensite = 1;
															d.etat_case = EtatCase.FEU;
															f.remove(Bouton.get(k));	
															gbc.gridx = d.colonne_j;
															gbc.gridy = d.ligne_i;
															f.add(Bouton_Feu.get(k),gbc);
															Couple.put(d,Bouton_Feu.get(k));
															f.repaint();
															f.revalidate();
															Panel.add(new JLabel("La " + d.nature_case.toString() + " "  + d.getPosition().toString() + " a pris feu."));
															System.out.println(initialisation());	}
													}
													k++;
												}
											}
										}
									}
									Plaine.gestion_intensite();
									if (Plaine.etat_case == EtatCase.FEU){
										Panel.add(new JLabel("La Plaine " + Plaine.getPosition().toString() + " a pour intensité " + Plaine.intensite));
									}
									if (Plaine.etat_case == EtatCase.CARBONISE) {
										
											JLabel Cendre = new JLabel(CendreV2);
											f.remove(Bouton_Feu.get(r));
											gbc.gridx = Plaine.getPosition().get(0);
											gbc.gridy = Plaine.getPosition().get(1);
											f.add(Cendre,gbc);
											f.repaint();
											f.revalidate();
											Panel.add(new JLabel("La Plaine " + Plaine.getPosition().toString() + " est en cendre."));	
									}
								}
								
								if (c.nature_case == NatureCase.MAISON) {
									Maison Maison = (Maison) c;
									int x = Maison.getPropagation();
									if ( x == 0){
									}
									else{
									if (Maison.etat_case == EtatCase.FEU) {
										for (int i = 0; i < Maison.getPropagationIncendie(x,toto).size(); i++){
											
											int colonne = Maison.getPropagationIncendie(x,toto).get(i).get(0);
											int ligne = Maison.getPropagationIncendie(x,toto).get(i).get(1);
											int k = 0;
											for (Case d : toto) {
												if (d.getCase(colonne,ligne) == true) {
													if (d.etat_case == EtatCase.INTACTE && d.nature_case != NatureCase.EAU) {
														d.intensite = 1;
														d.etat_case = EtatCase.FEU;
														f.remove(Bouton.get(k));	
														gbc.gridx = d.colonne_j;
														gbc.gridy = d.ligne_i;
														f.add(Bouton_Feu.get(k),gbc);
														Couple.put(d,Bouton_Feu.get(k));
														f.repaint();
														f.revalidate();
														Panel.add(new JLabel("La " +  d.nature_case.toString() + " "  + d.getPosition().toString() + " a pris feu."));
													}
												}
												k++;
											}
										}
									}
									}
									Maison.gestion_intensite();
									if (Maison.etat_case == EtatCase.FEU){
										Panel.add(new JLabel("La Maison " + Maison.getPosition().toString() + " a pour intensité " + Maison.intensite));
									}
									
									if (Maison.etat_case == EtatCase.CARBONISE) {
										
										JLabel Cendre = new JLabel(CendreV2);
										f.remove(Bouton_Feu.get(r));
										gbc.gridx = Maison.getPosition().get(0);
										gbc.gridy = Maison.getPosition().get(1);
										f.add(Cendre,gbc);
										f.repaint();
										f.revalidate();
										Panel.add(new JLabel("La Maison " + Maison.getPosition().toString() + " est en cendre."));
										nb_maison_cendre++;
									}
								}
								r++;			
							}
							for (Case g : toto){
								if (g.etat_case == EtatCase.FEU){
									nb_case_feu++;
									if (nb_case_feu == 0){
										
									}
								}

							}
							Panel.add(new JLabel("Il reste " + nb_case_feu + " case(s) encore en feu."));
							Panel.add(new JLabel("Il y a  " + nb_maison_cendre + " maison(s) en cendre."));
							if (nb_maison_cendre == 5){
								JOptionPane.showMessageDialog(null, "Il y a 5 maisons ou plus en cendre" + "\n " +  "Vous avez donc perdu la partie ! " + "\n" + "Dommage !", "Partie Perdu",JOptionPane.PLAIN_MESSAGE );
								Tour.cancel();
							}
							if (nb_case_feu == 0){
								JOptionPane.showMessageDialog(null, "Il n'y a plus aucun feu active" + "\n" + "Vous avez donc gagné !" + "\n" + "Bravo !", "Partie Gagné",JOptionPane.PLAIN_MESSAGE );
							}
							l.add(Panel);
							l.repaint();
							l.revalidate();
						}
					};
				Tour.schedule(Action,1500);
				}
				f.requestFocus();
			}
			});
			y++;
		}	
			
		/**
		 * Construction de l'interface 
		 */
		gbc.fill = GridBagConstraints.CENTER;
		int r = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (Case.get(r).etat_case == EtatCase.FEU) {
					gbc.gridx = j;
					gbc.gridy = i;
					f.add(Bouton_Feu.get(r),gbc);
				}
				if (Case.get(r).presence_pompier == true){
					gbc.gridx = j;
					gbc.gridy = i;
					if (Case.get(r).nature_case == NatureCase.PLAINE){
						f.add(Bouton_Case_Pompier.get(r),gbc);
					}
					if (Case.get(r).nature_case == NatureCase.FORET){
						f.add(Bouton_Case_Pompier.get(r),gbc);
					}
					if (Case.get(r).nature_case == NatureCase.PLAINE){
						f.add(Bouton_Case_Pompier.get(r),gbc);
					}
				}
				else {
					gbc.gridx = j;
					gbc.gridy = i;
					f.add(Bouton.get(r),gbc);
				}
				r++;
			}
		}

		/**
		 * Ajout d'un Barre de tache qui permet au joueur de sauvegarder sa partie.
		 */
		JMenuBar MenuBar = new JMenuBar();
		JMenu Menu = new JMenu("Sauvegarder");
		JMenuItem Sauvegarder = new JMenuItem("Sauvegarde la partie");
		
		Sauvegarder.addActionListener(new ActionListener (){

			public void actionPerformed(ActionEvent e) {
				try {
					sauvegarder(toto);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		Menu.add(Sauvegarder);
		MenuBar.add(Menu);
		gbc.gridx = 11;
		gbc.gridy = 0;
		f.add(MenuBar);
		
		
		f.addKeyListener(Deplacement);
		
		f.pack();
		f.setVisible(true);
		l.setVisible(true);
		
		
		return toto;
	}
}
