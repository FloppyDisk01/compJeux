package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Jeu.Jeu;
import Model.Jeu_modele;

@SuppressWarnings("serial")
public class PSelect_suppr_modif_jeu_admin extends JPanel{
	private JTable jeux;
	private JButton bmodif;
	private JButton bsuppr;
	private JButton bretour;
	
	public PSelect_suppr_modif_jeu_admin() {
		
		String[] colonnes= {"Nom","Genre","Prix","date",
				"editeur","plateforme","Note"};
		DefaultTableModel tableModel = new DefaultTableModel(colonnes, 0);
		jeux=new JTable(tableModel);
		
		ArrayList<Jeu> al= Jeu_modele.getJeuTous();
		
		for (int i = 0; i < al.size(); i++){
			   String nom = al.get(i).getNom();
			   String genre_nom = al.get(i).getGenre().getName();
			   
			   double prix = al.get(i).getPrix();
			   int date = al.get(i).getDate();
			   String editeur_nom = al.get(i).getEditeur().getName();
			   String plateforme_nom = al.get(i).getPlateforme().getName();
			   double note_20 = al.get(i).getNote().getNote_sur_20();
			 
			 

			   Object[] data = {nom, genre_nom, prix, date, editeur_nom,
					   			plateforme_nom , note_20};

			   tableModel.addRow(data);

			}
		
		
		
		
		bmodif=new JButton("Modifier");
		bsuppr=new JButton("Supprimer");
		bretour=new JButton("Retour");
		
		
		this.add(jeux);
		this.add(bretour);
		
		this.add(bmodif);
		this.add(bsuppr);
		
		
		bretour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[4]);
			}
			
		});
		
		bmodif.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[7]);
			}
			
		});
		
		bsuppr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[4]);
			}
			
		});
		
	}
}
