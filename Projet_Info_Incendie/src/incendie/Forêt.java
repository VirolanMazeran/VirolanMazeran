package incendie;

import java.util.ArrayList;
import java.util.List;

public class Forêt extends Case implements Propagation{
	
	/**
	 * 
	 * @param colonne_j
	 * @param ligne_i
	 * @param intensite
	 * @param etat_case
	 * @param presence_pompier
	 * @return un objet Foret avec une intensité, un etat et une présence de pompier donnés.
	 */
	public Forêt(int colonne_j, int ligne_i, int intensite, EtatCase etat_case, Boolean presence_pompier){
		super(colonne_j, ligne_i, intensite, etat_case, presence_pompier);
		this.colonne_j = colonne_j;
		this.ligne_i = ligne_i;
		this.nature_case = NatureCase.FORET;
		this.intensite = intensite;
		this.etat_case = etat_case;
		this.presence_pompier = presence_pompier;
	}
	
	/**
	 * Cette méthode augmente l'intensité des cases de type FORET de 1. Si l'intensité atteind 5, l'état de la case devient CARBONISE.
	 */
	public void  gestion_intensite(){
		if (this.etat_case == EtatCase.FEU){
			this.intensite = this.intensite + 1;
			if (this.intensite > 5){
				this.etat_case = EtatCase.CARBONISE;
				this.intensite = 1;
			}
		}
	}
	
	public int getPropagation(){
		int i = this.intensite;
		if (i != 5){
			int n = (int) (Math.random()*(2*i + 1));
			return n;
		}
		else{
			int n = (int) (Math.random()*(8+1));
			if (n == 0){
				n = 1;
				return n; 
			}
			else {
			return n;
			}
		}
	}
	
	/**
	 * Cette méthode retourne un nombre aléatoire x de positions choisies aléatoirement parmis la liste des positions accessibles depuis la case en feu.
	 * @return liste de liste  
	 */
	public List<List<Integer>> getPropagationIncendie(int x, List<Case> liste){
		
		
		List<List<Integer>> List_pos_accessibles = new ArrayList<>();
		for(int t = -1; t<2; t++) {
			
			for(int s = -1; s<2; s++) {
				
				if(ligne_i+t>=0 && ligne_i+t<10 && s+colonne_j>=0 && s+colonne_j<10 && getNature_case(colonne_j+s,ligne_i+t, liste) != NatureCase.EAU && getEtat_case(colonne_j+s,ligne_i+t, liste) == EtatCase.INTACTE) {
					List<Integer> pos = new ArrayList<Integer>();
					pos.add(colonne_j+t);
					pos.add(ligne_i+s);
					List_pos_accessibles.add(pos);
				}}}
		if(x >= List_pos_accessibles.size()) {
			return List_pos_accessibles;
		}
		
		else {
			List<List<Integer>> List_prop = new ArrayList<>();
			for(int w=1; w<x; w++) {
				
				if(List_pos_accessibles.isEmpty() == true){
					break;
				}
				else{
					int p = (int) (Math.random()*List_pos_accessibles.size());
					List_prop.add(List_pos_accessibles.get(p));
					List_pos_accessibles.remove(p);
				}
				
				
			}
			return List_prop;
		}
		
	
	}
	
	
	public String toString(){
		if (this.etat_case != EtatCase.CARBONISE){
			return "La Forêt se situant � la position " + "[" + this.colonne_j + "," + this.ligne_i + "]" + " a pour intensit� " + this.intensite + "." + " L'�tat de la case est " + this.etat_case + ".";
		}
		else{
			return "La Forêt se situant � la position " + "[" + this.colonne_j + "," + this.ligne_i + "]." + " L'�tat de la case est " + this.etat_case + " donc son intensit� est de " + this.intensite + ".";
		}
	}
}
