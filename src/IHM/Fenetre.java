package IHM;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	static CardLayout cl=new CardLayout();
	
	static JPanel content=new JPanel();
	
	static String[] listcontent= {"Connexion","Recherche_user","Resultats_recherche_user",
			"Fiche_jeu","Menu_admin", "Ajout_jeu_admin","Select_suppr_modif_jeu",
			"Modif_jeu"
	};
	
	public Fenetre() {
		this.setTitle("Comparateur");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PConnexion connexion=new PConnexion();
		PAjout_jeu_admin ajout_jeu_admin=new PAjout_jeu_admin();
		PFiche_jeu fiche_jeu=new PFiche_jeu();
		PMenu_admin menu_admin=new PMenu_admin();
		PModif_jeu_admin modif_jeu_admin=new PModif_jeu_admin();
		PRecherche_user recherche_user=new PRecherche_user();
		PResultats_user resultats=new PResultats_user();
		PSelect_suppr_modif_jeu_admin select_suppr_modif_jeu_admin=
				new PSelect_suppr_modif_jeu_admin();
		
		content.setLayout(cl);
		content.add(connexion,listcontent[0]);
		content.add(recherche_user,listcontent[1]);
		content.add(resultats,listcontent[2]);
		content.add(fiche_jeu,listcontent[3]);
		content.add(menu_admin,listcontent[4]);
		content.add(ajout_jeu_admin,listcontent[5]);
		content.add(select_suppr_modif_jeu_admin,listcontent[6]);
		content.add(modif_jeu_admin,listcontent[7]);
		
		
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
