package incendie;

/**
 * 
 * @author mazeranpaul_virolanjonathan
 * @see Case
 */
public class Eau extends Case {
	
	
	/**
	 * Les cases de types EAU on un constructeur spécial.
	 * @param colonne_j abscisse de la case
	 * @param ligne_i ordonnée de la case
	 * @return un objet Case de type EAU, d'état INTACT, d'intensité 0, de coordonées (i,j) et absence de pompier
	 */
	public Eau(int colonne_j,int ligne_i){
		super(colonne_j, ligne_i);
		this.colonne_j = colonne_j;
		this.ligne_i = ligne_i;
		this.nature_case = NatureCase.EAU;
		this.intensite = 0;
		this.etat_case = EtatCase.INTACTE;
		this.presence_pompier = false;
		
	}
	
	
	/**
	 * La méthode gestion intensité est obsolète car les cases EAU ne peuvent pas bruler
	 */
	public void  gestion_intensite(){
	}
	
	
	public String toString(){
			return "Cette case se situant à la position " + "[" + this.ligne_i + "," + this.colonne_j + "]" + " est de type eau donc elle a pour intensité 0." + " L'état de la case est donc intacte";
	}
}
