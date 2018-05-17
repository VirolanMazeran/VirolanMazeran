package incendie;

import java.util.ArrayList;
import java.util.List;

	/**
	 * @author mazeranpaul_virolanjonathan
	 * @see Case
	 */
public class Pompier {
	int colonne_j;
	int ligne_i;
	int vie_bonus;
	
	/**
	 * @param i ordonnée du pompier sur la grille
	 * @param j abscisse du pompier sur la grille
	 * Le constructeur avec vie_bonus n'est pas encore implémenté et le sera sous reserve de temps disponible.  
	 */
	public Pompier(int j, int i) {
		this.colonne_j=j;
		this.ligne_i=i;
	}
	
	
	
	/**
	 * cette méthode regroupe les coordonnées (i,j) d'un objet Pompier dans une ArrayListe.
	 * @return liste [i,j]
	 */
	
	public List<Integer> getPosition(){
		
		List<Integer> Position = new ArrayList<Integer>();
		Position.add(this.colonne_j);
		Position.add(this.ligne_i);
		return Position;
		}
		
	
	
	/**
	 * Cette méthode prend en entrée un objet Pompier et la case cible du déplacement. Crée une liste des position accessible par le pompier depuis sa case source. Et enfin vérifie si la case cible (i,j) est dans la liste des positions accessible par le pompier.
	 * @param p objet pompier
	 * @param i ordonnée de la case cible
	 * @param j abscisse de la case cible
	 * @return boolean (True est changement des coordonnées du pompier / False et message d'erreur.
	 */
	public boolean deplacement(int i, int j) {	
		
		List<List<Integer>> List_pos_accessibles = new ArrayList<>();
		for(int t = -1; t<2; t++) {
			
			for(int s = -1; s<2; s++) {
				
				if(colonne_j+t>=0 && colonne_j+t<10 && s+ligne_i>=0 && s+ligne_i<10) {
					List<Integer> pos = new ArrayList<Integer>();
					pos.add(colonne_j + t);
					pos.add(ligne_i + s);
					List_pos_accessibles.add(pos);
				}}}
	
		for (List<Integer> e : List_pos_accessibles){
			if(e.get(0) == j && e.get(1)== i) {
				setLigne_i(i);
				setColonne_j(j);
				return true;
			}
			
		}
		return false;
	}
	
	
	/**
	 * Cette méthode vérifie que la case choisie est accessibe et en feu. Si c'est le cas, l'intensitée est diminuée.
	 * @param p objet Pompier
	 * @param c objet Case
 	 *@return boolean (True et changement de l'intensité de la case/ False et message d'erreur).
 	 */
	public boolean eteindreFeu(Case c) {
		
		List<List<Integer>> List_pos_accessibles = new ArrayList<>();
		int j = c.getPosition().get(0);
		int i = c.getPosition().get(1);
		for(int t = -1; t<2; t++) {
			
			for(int s = -1; s<2; s++) {
				
				if(colonne_j+t>=0 && colonne_j+t<10 && s+ligne_i>=0 && s+ligne_i<10) {
					List<Integer> pos = new ArrayList<Integer>();
					pos.add(colonne_j+t);
					pos.add(ligne_i+s);
					List_pos_accessibles.add(pos);
					
					
				}}}
		
		for (List<Integer> e : List_pos_accessibles){
			
			if(e.get(0) == j && e.get(1) == i) {
					if(c.etat_case == EtatCase.FEU) {
	
						int intensite = c.getIntensite();
						if (intensite == 1 || intensite == 0) {
							c.intensite = 0;
						}
						else {
							c.intensite = intensite - 2;
						}		
					}
					return true;
				}
			}
		return false;		
	}
				
				
		
	public void gestion_intensite() {	
	}
		
		
	public int getLigne_i() {
		return ligne_i;
	}

	public void setLigne_i(int ligne_i) {
		this.ligne_i = ligne_i;
	}

	public int getColonne_j() {
		return colonne_j;
	}

	public void setColonne_j(int ligne_j) {
		this.colonne_j = ligne_j;
	}

	public int getVie_bonus() {
		return vie_bonus;
	}

	public void setVie_bonus(int vie_bonus) {
		this.vie_bonus = vie_bonus;
	}
}
