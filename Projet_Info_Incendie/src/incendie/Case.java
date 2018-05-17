package incendie;

import java.util.ArrayList;
import java.util.List;

	
	/**
	 *@author mazeranpaul_virolanjonathan
	 */
public abstract class Case   {
	
	public int ligne_i;
	public int colonne_j;
	public NatureCase nature_case;
	public int intensite;
	public EtatCase etat_case;
	public boolean presence_pompier;

	
	/**
	 * 
	 * @param colonne_j
	 * @param ligne_i
	 * @param intensite
	 * @param etat_case
	 * @param presence_pompier
	 */
	public Case(int colonne_j, int ligne_i, int intensite, EtatCase etat_case, Boolean presence_pompier){
		this.colonne_j = colonne_j;
		this.ligne_i = ligne_i;
		this.intensite = intensite;
		this.etat_case = etat_case;
		this.presence_pompier = presence_pompier;
	}
	
	public Case(int colonne_j, int ligne_i){
		this.colonne_j = colonne_j;
		this.ligne_i = ligne_i;
	}
	
	/**
	 * Cette méthode vérifie que un objet case à pour coordonées (m,n)
	 * @param m
	 * @param n
	 * @return boolean
	 */
	public boolean getCase(int m, int n) {
		if ( getPosition().get(0) == m && getPosition().get(1) == n) {
				return true;
			}
		else {
				return false;
		}
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

	public NatureCase getNature_case() {
		return nature_case;
	}
	
	public NatureCase getNature_case(int i, int j, List<Case> liste_cases) {
	
			
		for(Case c1 : liste_cases) {
			if(c1.ligne_i==i && c1.colonne_j==j) {
				return c1.getNature_case();
				
			}
		}
		
	
		return NatureCase.EAU;
	}


	public EtatCase getEtat_case() {
		return etat_case;
	}
	
	public EtatCase getEtat_case(int i, int j, List<Case> liste_cases) {
		

			
		for(Case c1 : liste_cases) {
			if(c1.ligne_i==i && c1.colonne_j==j) {
				return c1.getEtat_case();
				
			}
		}
		
	
		return EtatCase.FEU;
	}

	public int getIntensite() {
		return intensite;
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

	public void setColonne_j(int colonne_j) {
		this.colonne_j = colonne_j;
	}
	
	public abstract void gestion_intensite();	
	
}
