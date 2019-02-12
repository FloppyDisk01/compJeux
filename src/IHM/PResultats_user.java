package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import Comparateur.Comparateur;
import Jeu.Jeu;
import Model.Jeu_modele;

@SuppressWarnings("serial")
public class PResultats_user extends JPanel{
	
	private JTable jeux;
	private JButton plus_infos;
	private JButton nouvelle_recherche;
	
	public PResultats_user() {
		Comparateur comp=PRecherche_user.getComp();
		ArrayList<Jeu> al=Jeu_modele.getJeuTous();
		
		Collections.sort(al, comp);
		
		String[] colonnes= {"Nom","Genre","Prix","date","editeur","plateforme","Note","Lien"};
		jeux=new JTable();
		
		
		plus_infos=new JButton("+ d'infos");
		nouvelle_recherche=new JButton("Nouvelle Recherche");
		
		this.add(jeux);
		this.add(plus_infos);
		this.add(nouvelle_recherche);
		
		plus_infos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[3]);
			}
			
		});
		
		nouvelle_recherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[1]);
			}
			
		});
	}
}
