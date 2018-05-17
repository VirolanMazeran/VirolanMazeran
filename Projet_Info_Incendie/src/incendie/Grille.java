package incendie;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Grille  {
	
	/**
	 * Cette méthode crée toute les cases et les boutons qui nous permettra de répresenter la grille.
	 * @return La grille initialie sous forme de couple Map<Case, JButton>.
	 */
	
	public static Map<Case, JButton> initialisation() {
		
		Map<Case, JButton> Couple = new LinkedHashMap<>();
		
		/**
		 * Importation des Images et modifications de celle-ci pour qu'elles ont la même image pour qu'elle soient tous de même taille.
		 */
		ImageIcon Forêt = new ImageIcon("Images/Java2d_arbre.jpg");
		ImageIcon ForêtV2 = new ImageIcon(Forêt.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Eau = new ImageIcon("Images/Java2d_eau.jpg");
		ImageIcon EauV2 = new ImageIcon(Eau.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Plaine = new ImageIcon("Images/Java2d_Plaine.jpg");
		ImageIcon PlaineV2 = new ImageIcon(Plaine.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Maison = new ImageIcon("Images/Java2d_Maison.jpg");
		ImageIcon MaisonV2 = new ImageIcon(Maison.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Maison_Feu = new ImageIcon("Images/Java2d_Maison_en_Feu.jpg");
		ImageIcon Maison_FeuV2 = new ImageIcon(Maison_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Plaine_Feu = new ImageIcon("Images/Java2d_Plaine_en_Feu.jpg");
		ImageIcon Plaine_FeuV2 = new ImageIcon(Plaine_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Forêt_Feu = new ImageIcon("Images/Java2d_Forêt_en_Feu.jpeg");
		ImageIcon Forêt_FeuV2 = new ImageIcon(Forêt_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


		
		/**
		 * 1 ère ligne de la grille
		 */
		JButton E1 = new JButton(EauV2);
		Eau e1 = new Eau(0,0);
		Couple.put(e1,E1);
		
		JButton E2 = new JButton(EauV2);
		Eau e2 = new Eau(1,0);
		Couple.put(e2,E2);

		JButton E3 = new JButton(EauV2);
		Eau e3 = new Eau(2,0);
		Couple.put(e3,E3);
		
		JButton P1 = new JButton(PlaineV2);
		Plaine p1 = new Plaine(3,0,0,EtatCase.INTACTE,false);
		Couple.put(p1,P1);
		
		JButton P2 = new JButton(PlaineV2);
		Plaine p2 = new Plaine(4,0,0,EtatCase.INTACTE,false);
		Couple.put(p2,P2);
		
		JButton P3 = new JButton(PlaineV2);
		Plaine p3 = new Plaine(5,0,0,EtatCase.INTACTE,false);
		Couple.put(p3,P3);
		
		JButton F1 = new JButton(ForêtV2);
		Forêt f1 = new Forêt(6,0,0,EtatCase.INTACTE,false);
		Couple.put(f1,F1);
		
		JButton F2 = new JButton(ForêtV2);
		Forêt f2 = new Forêt(7,0,0,EtatCase.INTACTE,false);
		Couple.put(f2,F2);
		
		JButton F3 = new JButton(ForêtV2);
		Forêt f3 = new Forêt(8,0,0,EtatCase.INTACTE,false);
		Couple.put(f3,F3);
		
		JButton F4 = new JButton(ForêtV2);
		Forêt f4 = new Forêt(9,0,0,EtatCase.INTACTE,false);
		Couple.put(f4,F4);
		
		/**
		 * 2eme ligne de la grille
		 */		
		JButton E4 = new JButton(EauV2);
		Eau e4 = new Eau(0,1);
		Couple.put(e4,E4);
		
		JButton E5 = new JButton(EauV2);
		Eau e5 = new Eau(1,1);
		Couple.put(e5,E5);
		
		JButton P4 = new JButton(PlaineV2);
		Plaine p4 = new Plaine(2,4,0,EtatCase.INTACTE,false);
		Couple.put(p4,P4);
		
		JButton P5 = new JButton(PlaineV2);
		Plaine p5 = new Plaine(3,1,0,EtatCase.INTACTE,false);
		Couple.put(p5,P5);
		
		JButton P6 = new JButton(PlaineV2);
		Plaine p6 = new Plaine(4,1,0,EtatCase.INTACTE,false);
		Couple.put(p6,P6);
		
		JButton P7 = new JButton(PlaineV2);
		Plaine p7 = new Plaine(5,1,0,EtatCase.INTACTE,false);
		Couple.put(p7,P7);
		
		JButton F5 = new JButton(ForêtV2);
		Forêt f5= new Forêt(6,1,0,EtatCase.INTACTE,false);
		Couple.put(f5,F5);
		
		JButton F6 = new JButton(ForêtV2);
		Forêt f6 = new Forêt(7,1,0,EtatCase.INTACTE,false);
		Couple.put(f6,F6);
		
		JButton F7 = new JButton(ForêtV2);
		Forêt f7 = new Forêt(8,1,0,EtatCase.INTACTE,false);
		Couple.put(f7,F7);
		
		JButton F8 = new JButton(ForêtV2);
		Forêt f8 = new Forêt(9,1,0,EtatCase.INTACTE,false);
		Couple.put(f8,F8);
		
		/**
		 * 3eme ligne de la grille
		 */	
		JButton E6 = new JButton(EauV2);
		Eau e6 = new Eau(0,2);
		Couple.put(e6,E6);
		
		JButton M1 = new JButton(MaisonV2);
		Maison m1 = new Maison(1,2,0,EtatCase.INTACTE,false);
		Couple.put(m1,M1);
		
		JButton M2 = new JButton(MaisonV2);
		Maison m2 = new Maison(2,2,0,EtatCase.INTACTE,false);
		Couple.put(m2,M2);
		
		JButton M3 = new JButton(MaisonV2);
		Maison m3 = new Maison(3,2,0,EtatCase.INTACTE,false);
		Couple.put(m3,M3);
		
		JButton P8 = new JButton(PlaineV2);
		Plaine p8 = new Plaine(4,2,0,EtatCase.INTACTE,false);
		Couple.put(p8,P8);
		
		JButton P9 = new JButton(PlaineV2);
		Plaine p9 = new Plaine(5,2,0,EtatCase.INTACTE,false);
		Couple.put(p9,P9);
		
		JButton P10 = new JButton(PlaineV2);
		Plaine p10 = new Plaine(6,2,0,EtatCase.INTACTE,false);
		Couple.put(p10,P10);
		
		JButton P11 = new JButton(PlaineV2);
		Plaine p11 = new Plaine(7,2,0,EtatCase.INTACTE,false);
		Couple.put(p11,P11);
		
		JButton P12 = new JButton(PlaineV2);
		Plaine p12 = new Plaine(8,2,0,EtatCase.INTACTE,false);
		Couple.put(p12,P12);
		
		JButton M4 = new JButton(MaisonV2);
		Maison m4 = new Maison(9,2,0,EtatCase.INTACTE,false);
		Couple.put(m4,M4);
		
		/**
		 * 4eme ligne de la grille
		 */	
		JButton P13 = new JButton(PlaineV2);
		Plaine p13 = new Plaine(0,3,0,EtatCase.INTACTE,false);
		Couple.put(p13,P13);
		
		JButton P14 = new JButton(PlaineV2);
		Plaine p14 = new Plaine(1,3,0,EtatCase.INTACTE,false);
		Couple.put(p14,P14);
		
		JButton P15 = new JButton(PlaineV2);
		Plaine p15 = new Plaine(2,3,0,EtatCase.INTACTE,false);
		Couple.put(p15,P15);
		
		JButton P16 = new JButton(PlaineV2);
		Plaine p16 = new Plaine(3,3,0,EtatCase.INTACTE,false);
		Couple.put(p16,P16);
		
		JButton P17 = new JButton(PlaineV2);
		Plaine p17 = new Plaine(4,3,0,EtatCase.INTACTE,false);
		Couple.put(p17,P17);
		
		JButton E7 = new JButton(EauV2);
		Eau e7 = new Eau(5,3);
		Couple.put(e7,E7);
		
		JButton E8 = new JButton(EauV2);
		Eau e8 = new Eau(6,3);
		Couple.put(e8,E8);
	
		JButton P18 = new JButton(PlaineV2);
		Plaine p18 = new Plaine(7,3,0,EtatCase.INTACTE,false);
		Couple.put(p18,P18);
		
		JButton P19 = new JButton(PlaineV2);
		Plaine p19 = new Plaine(8,3,0,EtatCase.INTACTE,false);
		Couple.put(p19,P19);
		
		JButton M5 = new JButton(MaisonV2);
		Maison m5 = new Maison(9,3,0,EtatCase.INTACTE,false);
		Couple.put(m5,M5);
		
		/**
		 * 5eme ligne de la grille
		 */	
		JButton F9 = new JButton(ForêtV2);
		Forêt f9 = new Forêt(0,4,0,EtatCase.INTACTE,false);
		Couple.put(f9,F9);
		
		JButton F10 = new JButton(ForêtV2);
		Forêt f10 = new Forêt(1,4,0,EtatCase.INTACTE,false);
		Couple.put(f10,F10);
		
		JButton F11 = new JButton(ForêtV2);
		Forêt f11 = new Forêt(2,4,0,EtatCase.INTACTE,false);
		Couple.put(f11,F11);
		
		JButton F12 = new JButton(ForêtV2);
		Forêt f12 = new Forêt(3,4,0,EtatCase.INTACTE,false);
		Couple.put(f12,F12);
		
		JButton E9 = new JButton(EauV2);
		Eau e9 = new Eau(4,4);
		Couple.put(e9,E9);
		
		JButton E10 = new JButton(EauV2);
		Eau e10 = new Eau(5,4);
		Couple.put(e10,E10);
		
		JButton E11 = new JButton(EauV2);
		Eau e11 = new Eau(6,4);
		Couple.put(e11,E11);
		
		JButton E12 = new JButton(EauV2);
		Eau e12 = new Eau(7,4);
		Couple.put(e12,E12);
		
		JButton P20 = new JButton(PlaineV2);
		Plaine p20 = new Plaine(8,4,0,EtatCase.INTACTE,false);
		Couple.put(p20,P20);
		
		JButton M6 = new JButton(MaisonV2);
		Maison m6 = new Maison(9,4,0,EtatCase.INTACTE,false);
		Couple.put(m6,M6);
		
		/**
		 * 6eme ligne de la grille
		 */
		JButton F13 = new JButton(ForêtV2);
		Forêt f13 = new Forêt(0,5,0,EtatCase.INTACTE,false);
		Couple.put(f13,F13);
		
		JButton F14 = new JButton(ForêtV2);
		Forêt f14 = new Forêt(1,5,0,EtatCase.INTACTE,false);
		Couple.put(f14,F14);
		
		JButton F15 = new JButton(ForêtV2);
		Forêt f15 = new Forêt(2,5,0,EtatCase.INTACTE,false);
		Couple.put(f15,F15);
		
		JButton F16 = new JButton(ForêtV2);
		Forêt f16 = new Forêt(3,5,0,EtatCase.INTACTE,false);
		Couple.put(f16,F16);
		
		JButton P21 = new JButton(PlaineV2);
		Plaine p21 = new Plaine(4,5,0,EtatCase.INTACTE,false);
		Couple.put(p21,P21);
		
		JButton E13 = new JButton(EauV2);
		Eau e13 = new Eau(5,5);
		Couple.put(e13,E13);
		
		JButton E14 = new JButton(EauV2);
		Eau e14 = new Eau(6,5);
		Couple.put(e14,E14);
		
		JButton P22 = new JButton(Plaine_FeuV2);
		Plaine p22 = new Plaine(7,5,1,EtatCase.FEU,false);
		Couple.put(p22,P22);
		
		JButton P23 = new JButton(PlaineV2);
		Plaine p23 = new Plaine(8,5,0,EtatCase.INTACTE,false);
		Couple.put(p23,P23);
		
		JButton P24 = new JButton(PlaineV2);
		Plaine p24 = new Plaine(9,5,0,EtatCase.INTACTE,false);
		Couple.put(p24,P24);
		
		/**
		 * 7eme ligne de la grille
		 */
		JButton P25 = new JButton(PlaineV2);
		Plaine p25 = new Plaine(0,6,0,EtatCase.INTACTE,false);
		Couple.put(p25,P25);
		
		JButton P26 = new JButton(PlaineV2);
		Plaine p26 = new Plaine(1,6,0,EtatCase.INTACTE,false);
		Couple.put(p26,P26);
		
		JButton P27 = new JButton(PlaineV2);
		Plaine p27 = new Plaine(2,6,0,EtatCase.INTACTE,false);
		Couple.put(p27,P27);
		
		JButton P28 = new JButton(PlaineV2);
		Plaine p28 = new Plaine(3,6,0,EtatCase.INTACTE,false);
		Couple.put(p28,P28);
		
		JButton P29 = new JButton(PlaineV2);
		Plaine p29 = new Plaine(4,6,0,EtatCase.INTACTE,true);
		Couple.put(p29,P29);
		
		JButton P30 = new JButton(PlaineV2);
		Plaine p30 = new Plaine(5,6,0,EtatCase.INTACTE,false);
		Couple.put(p30,P30);
		
		JButton P31 = new JButton(PlaineV2);
		Plaine p31 = new Plaine(6,6,0,EtatCase.INTACTE,false);
		Couple.put(p31,P31);
		
		JButton P32 = new JButton(PlaineV2);
		Plaine p32 = new Plaine(7,6,0,EtatCase.INTACTE,false);
		Couple.put(p32,P32);
		
		JButton F17 = new JButton(ForêtV2);
		Forêt f17 = new Forêt(8,6,0,EtatCase.INTACTE,false);
		Couple.put(f17,F17);
		
		JButton F18 = new JButton(ForêtV2);
		Forêt f18 = new Forêt(9,6,0,EtatCase.INTACTE,false);
		Couple.put(f18,F18);
		
		/**
		 * 8eme ligne de la grille
		 */
		JButton P33 = new JButton(PlaineV2);
		Plaine p33 = new Plaine(0,7,0,EtatCase.INTACTE,false);
		Couple.put(p33,P33);
		
		JButton M7 = new JButton(MaisonV2);
		Maison m7 = new Maison(1,7,0,EtatCase.INTACTE,false);
		Couple.put(m7,M7);
		
		JButton P34 = new JButton(PlaineV2);
		Plaine p34 = new Plaine(2,7,0,EtatCase.INTACTE,false);
		Couple.put(p34,P34);
		
		JButton M8 = new JButton(MaisonV2);
		Maison m8 = new Maison(3,7,0,EtatCase.INTACTE,false);
		Couple.put(m8,M8);
		
		JButton P35 = new JButton(PlaineV2);
		Plaine p35 = new Plaine(4,7,0,EtatCase.INTACTE,false);
		Couple.put(p35,P35);
		
		JButton M9 = new JButton(MaisonV2);
		Maison m9 = new Maison(5,7,0,EtatCase.INTACTE,false);
		Couple.put(m9,M9);
		
		JButton P36 = new JButton(PlaineV2);
		Plaine p36 = new Plaine(6,7,0,EtatCase.INTACTE,false);
		Couple.put(p36,P36);
		
		JButton P37 = new JButton(PlaineV2);
		Plaine p37 = new Plaine(7,7,0,EtatCase.INTACTE,false);
		Couple.put(p37,P37);
		
		JButton P38 = new JButton(PlaineV2);
		Plaine p38 = new Plaine(8,7,0,EtatCase.INTACTE,false);
		Couple.put(p38,P38);
		
		JButton M10 = new JButton(MaisonV2);
		Maison m10 = new Maison(9,7,0,EtatCase.INTACTE,false);
		Couple.put(m10,M10);
		
		/**
		 * 9eme ligne de la grille
		 */
		JButton P39 = new JButton(PlaineV2);
		Plaine p39 = new Plaine(0,8,0,EtatCase.INTACTE,false);
		Couple.put(p39,P39);
		
		JButton P40 = new JButton(PlaineV2);
		Plaine p40 = new Plaine(1,8,0,EtatCase.INTACTE,false);
		Couple.put(p40,P40);
		
		JButton P41 = new JButton(PlaineV2);
		Plaine p41 = new Plaine(2,8,0,EtatCase.INTACTE,false);
		Couple.put(p41,P41);
		
		JButton P42 = new JButton(PlaineV2);
		Plaine p42 = new Plaine(3,8,0,EtatCase.INTACTE,false);
		Couple.put(p42,P42);
		
		JButton P43 = new JButton(PlaineV2);
		Plaine p43 = new Plaine(4,8,0,EtatCase.INTACTE,false);
		Couple.put(p43,P43);
		
		JButton P45 = new JButton(PlaineV2);
		Plaine p45 = new Plaine(5,8,0,EtatCase.INTACTE,false);
		Couple.put(p45,P45);
		
		JButton P46 = new JButton(PlaineV2);
		Plaine p46 = new Plaine(6,8,0,EtatCase.INTACTE,false);
		Couple.put(p46,P46);
		
		JButton P47 = new JButton(PlaineV2);
		Plaine p47 = new Plaine(7,8,0,EtatCase.INTACTE,false);
		Couple.put(p47,P47);
		
		JButton F19 = new JButton(ForêtV2);
		Forêt f19 = new Forêt(8,8,0,EtatCase.INTACTE,false);
		Couple.put(f19,F19);
		
		JButton F20 = new JButton(ForêtV2);
		Forêt f20 = new Forêt(9,8,0,EtatCase.INTACTE,false);
		Couple.put(f20,F20);
		
		/**
		 * 10eme ligne de la grille
		 */		JButton P48 = new JButton(PlaineV2);
		Plaine p48 = new Plaine(0,9,0,EtatCase.INTACTE,false);
		Couple.put(p48,P48);
		
		JButton M11 = new JButton(MaisonV2);
		Maison m11 = new Maison(1,9,0,EtatCase.INTACTE,false);
		Couple.put(m11,M11);
		
		JButton P49 = new JButton(PlaineV2);
		Plaine p49 = new Plaine(2,9,0,EtatCase.INTACTE,false);
		Couple.put(p49,P49);
		
		JButton M12 = new JButton(MaisonV2);
		Maison m12 = new Maison(3,9,0,EtatCase.INTACTE,false);
		Couple.put(m12,M12);
		
		JButton P50 = new JButton(PlaineV2);
		Plaine p50 = new Plaine(4,9,0,EtatCase.INTACTE,false);
		Couple.put(p50,P50);
		
		JButton M13 = new JButton(MaisonV2);
		Maison m13 = new Maison(5,9,0,EtatCase.INTACTE,false);
		Couple.put(m13,M13);
		
		JButton P51 = new JButton(PlaineV2);
		Plaine p51 = new Plaine(6,9,0,EtatCase.INTACTE,false);
		Couple.put(p51,P51);
		
		JButton P52 = new JButton(PlaineV2);
		Plaine p52 = new Plaine(7,9,0,EtatCase.INTACTE,false);
		Couple.put(p52,P52);
		
		JButton F21 = new JButton(ForêtV2);
		Forêt f21 = new Forêt(8,9,0,EtatCase.INTACTE,false);
		Couple.put(f21,F21);
		
		JButton F22 = new JButton(ForêtV2);
		Forêt f22 = new Forêt(9,9,0,EtatCase.INTACTE,false);
		Couple.put(f22,F22);
		
		return Couple;
	}
	
	/**
	 * La méthode allumerFeu_Aleatoire prend la grille initiale et crée un feu aleatoirement sur l'interface.
	 * @return Un couple Map<Case, JButton>
	 */
	public static Map<Case, JButton> allumerFeu_Aleatoire(){
		
		ImageIcon Forêt = new ImageIcon("Images/Java2d_arbre.jpg");
		ImageIcon ForêtV2 = new ImageIcon(Forêt.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Eau = new ImageIcon("Images/Java2d_eau.jpg");
		ImageIcon EauV2 = new ImageIcon(Eau.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Plaine = new ImageIcon("Images/Java2d_Plaine.jpg");
		ImageIcon PlaineV2 = new ImageIcon(Plaine.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Maison = new ImageIcon("Images/Java2d_Maison.jpg");
		ImageIcon MaisonV2 = new ImageIcon(Maison.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		
		ImageIcon Maison_Feu = new ImageIcon("Images/Java2d_Maison_en_Feu.jpg");
		ImageIcon Maison_FeuV2 = new ImageIcon(Maison_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Plaine_Feu = new ImageIcon("Images/Java2d_Plaine_en_Feu.jpg");
		ImageIcon Plaine_FeuV2 = new ImageIcon(Plaine_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon Forêt_Feu = new ImageIcon("Images/Java2d_Forêt_en_Feu.jpeg");
		ImageIcon Forêt_FeuV2 = new ImageIcon(Forêt_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		
		Map<Case, JButton> Couple = new LinkedHashMap<>();
		int n = initialisation().size();
		List<Case> Liste = new ArrayList<>();
		;
		for (Case c : initialisation().keySet()){
			Liste.add(c);
		}
		
		int i = 0;
		for (JButton b : initialisation().values()){
			if (Liste.get(i).etat_case == EtatCase.FEU){
				Liste.get(i).etat_case = EtatCase.INTACTE;
				Liste.get(i).intensite = 0;
				if( Liste.get(i).nature_case == NatureCase.FORET){
					Couple.put(Liste.get(i), new JButton(ForêtV2));
				}
				if( Liste.get(i).nature_case == NatureCase.PLAINE){
					Couple.put(Liste.get(i), new JButton(PlaineV2));
				}
				if( Liste.get(i).nature_case == NatureCase.MAISON){
					Couple.put(Liste.get(i), new JButton(MaisonV2));
				}
			}
			else{
				Couple.put(Liste.get(i), b);
			}
			i++;
		}
		int j = 0;
		while (j == 0){
			int r = (int) (Math.random() * (n - 1));
			if(Liste.get(r).nature_case != NatureCase.EAU){
				if (Liste.get(r).presence_pompier == false){
				Case Case_Feu = Liste.get(r);
				Case_Feu.etat_case = EtatCase.FEU;
				if( Liste.get(r).nature_case == NatureCase.FORET){
					Couple.put(Liste.get(r), new JButton(Forêt_FeuV2));
				}
				if( Liste.get(r).nature_case == NatureCase.PLAINE){
					Couple.put(Liste.get(r), new JButton(Plaine_FeuV2));
				}
				if( Liste.get(r).nature_case == NatureCase.MAISON){
					Couple.put(Liste.get(r), new JButton(Maison_FeuV2));
				}
				j = 1;
				}
			}
		}
		
		return Couple;
	}
	
	/**
	 * Cette méthode ajoute une case dans notre base de donnée.
	 * @param c La case que l'on veut ajouter dans notre base de donnée.
	 * @param n Correspond à l'id de la case c.
	 * @throws SQLException
	 */
	public static void addCase(Case c, int n) throws SQLException {

		int i = c.getLigne_i();
		int j = c.getColonne_j();
		int intensite = c.getIntensite();
		String nature_case = c.getNature_case().toString();
		String etat_case = c.getEtat_case().toString();
		boolean presence_pompier = c.presence_pompier;

		Connection connection = ConnexionSingleton.getInstance();
		String sql = "INSERT INTO cases (id, ligne_i, colonne_j, nature_case, etat_case,  intensite, presence_pompier ) VALUES (?,?, ?, ?,?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);

		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, n);
		pStatement.setInt(2, i);
		pStatement.setInt(3, j);
		pStatement.setString(4, nature_case);
		pStatement.setString(5, etat_case);
		pStatement.setInt(6, intensite);
		pStatement.setBoolean(7, presence_pompier);
		System.out.println(pStatement.toString());
		pStatement.execute();

	}

	/**
	 * Sauvegarde toute les cases dans un base de donnée.
	 * @param List<Case> qui correspond au case dans l'interface au moment de la sauvegarde 
	 * @throws SQLException
	 */
	public static void sauvegarder(List<Case> liste) throws SQLException{
		
		
		Connection connection = ConnexionSingleton.getInstance();
		String sql = "DELETE FROM cases";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.execute();

		
		int n = liste.size();
		for(int i=0; i<n;i++){
			Case c = liste.get(i);
			addCase(c,i);
			
			
		}
		
		
		
	}
	/**
	 * Cette méthode charge une partie qui a été sauvegarde précédemment.
	 * @return Couple Map<Case, JButton> qui associe chaque case à son image (en fonction de son intensité, de son état et la présence ou non du pompier.
	 * @throws SQLException
	 */
	public static Map<Case, JButton> charger() throws SQLException {
		ImageIcon Forêt = new ImageIcon("Images/Java2d_arbre.jpg");
		ImageIcon ForêtV2 = new ImageIcon(Forêt.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Eau = new ImageIcon("Images/Java2d_eau.jpg");
		ImageIcon EauV2 = new ImageIcon(Eau.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Plaine = new ImageIcon("Images/Java2d_Plaine.jpg");
		ImageIcon PlaineV2 = new ImageIcon(Plaine.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Maison = new ImageIcon("Images/Java2d_Maison.jpg");
		ImageIcon MaisonV2 = new ImageIcon(Maison.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Maison_Feu = new ImageIcon("Images/Java2d_Maison_en_Feu.jpg");
		ImageIcon Maison_FeuV2 = new ImageIcon(Maison_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Plaine_Feu = new ImageIcon("Images/Java2d_Plaine_en_Feu.jpg");
		ImageIcon Plaine_FeuV2 = new ImageIcon(Plaine_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImageIcon Forêt_Feu = new ImageIcon("Images/Java2d_Forêt_en_Feu.jpeg");
		ImageIcon Forêt_FeuV2 = new ImageIcon(Forêt_Feu.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


		ImageIcon Cendre = new ImageIcon("Images/Java2d_cendre.jpg");
		ImageIcon CendreV2 = new ImageIcon(Cendre.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
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
				
		Map<Case, JButton> Couple = new LinkedHashMap<>();

		
		
		Connection connection = ConnexionSingleton.getInstance();
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM cases");
	

		while (result.next()) {

			int i = result.getInt("ligne_i");
			int j = result.getInt("colonne_j");
			NatureCase nature_case = NatureCase.valueOf(result.getString("nature_case"));
			int intensite = result.getInt("intensite");
			EtatCase etat_case = EtatCase.valueOf(result.getString("etat_case"));
			boolean presence_pompier = result.getBoolean("presence_pompier");

			if (nature_case == NatureCase.EAU) {
				Eau c = new Eau(i, j);
				Couple.put(c, new JButton(EauV2));

			}
			if (nature_case == NatureCase.FORET) {
				Forêt c = new Forêt(i, j, intensite, etat_case, presence_pompier);
				if (c.etat_case == EtatCase.INTACTE) {
					if (c.presence_pompier) {
						Couple.put(c, new JButton(Pompier_ForêtV2));
					} else {
						Couple.put(c, new JButton(ForêtV2));
					}
					if (c.etat_case == EtatCase.FEU) {
						if (c.presence_pompier) {
							Couple.put(c, new JButton(Pompier_Feu_ForêtV2));
						} else {
							Couple.put(c, new JButton(Forêt_FeuV2));
						}
					}
				} else {
					Couple.put(c, new JButton(CendreV2));
				}
			}
			if (nature_case == NatureCase.MAISON) {
				Maison c = new Maison(i, j, intensite, etat_case, presence_pompier);
				if (c.etat_case == EtatCase.INTACTE) {
					if (c.presence_pompier) {
						Couple.put(c, new JButton(Pompier_MaisonV2));
					} else {
						Couple.put(c, new JButton(MaisonV2));
					}
					if (c.etat_case == EtatCase.FEU) {
						if (c.presence_pompier) {
							Couple.put(c, new JButton(Pompier_Feu_MaisonV2));
						} else {
							Couple.put(c, new JButton(Maison_FeuV2));
						}
					}
				} else {
					Couple.put(c, new JButton(CendreV2));
				}
			} else {
				Plaine c = new Plaine(i, j, intensite, etat_case, presence_pompier);
				if (c.etat_case == EtatCase.INTACTE) {
					if (c.presence_pompier) {
						Couple.put(c, new JButton(Pompier_PlaineV2));
					} else {
						Couple.put(c, new JButton(PlaineV2));
					}
					if (c.etat_case == EtatCase.FEU) {
						if (c.presence_pompier) {
							Couple.put(c, new JButton(Pompier_Feu_PlaineV2));
						} else {
							Couple.put(c, new JButton(Plaine_FeuV2));
						}
					}
				} else {
					Couple.put(c, new JButton(CendreV2));
				}
			}
		}
		return Couple;
	}
	
}
