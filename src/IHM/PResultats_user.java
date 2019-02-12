package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Comparateur.Comparateur;
import Jeu.Jeu;
import Model.Jeu_modele;

@SuppressWarnings("serial")
public class PResultats_user extends JPanel{
	
	private JTable jeux;
	private JButton plus_infos;
	private JButton nouvelle_recherche;
	private static Jeu jeuchoisi;
	private static ArrayList<Jeu> al;
	
	public PResultats_user() {
		
		Comparateur comp=PRecherche_user.getComp();
		al=Jeu_modele.getJeuTous();
		
		
		if(comp!=null) {
			System.out.println("aaa");
			Collections.sort(al, comp);
		}
		
		
		
		String[] colonnes= {"Nom","Genre","Prix","date",
				"editeur","plateforme","Note",""
				};
		
		DefaultTableModel tableModel = new DefaultTableModel(colonnes, 0);
		
		for (int i = 0; i < al.size(); i++){
			   String nom = al.get(i).getNom();
			   String genre_nom = al.get(i).getGenre().getName();
			   
			   double prix = al.get(i).getPrix();
			   int date = al.get(i).getDate();
			   String editeur_nom = al.get(i).getEditeur().getName();
			   String plateforme_nom = al.get(i).getPlateforme().getName();
			   double note_20 = al.get(i).getNote().getNote_sur_20();
			   JButton plus_infos2 = new JButton("plus_infos");
			 
			 

			   Object[] data = {nom, genre_nom, prix, date, editeur_nom,
					   			plateforme_nom , note_20,plus_infos2};

			   tableModel.addRow(data);

			}
		
		jeux=new JTable(tableModel);
		
		
		
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

	public static ArrayList<Jeu> getAl() {
		return al;
	}

	public static void setAl(ArrayList<Jeu> al) {
		PResultats_user.al = al;
	}
	
	
}
