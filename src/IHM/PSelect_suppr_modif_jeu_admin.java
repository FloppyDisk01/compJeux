package IHM;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Jeu.Jeu;
import Model.Jeu_modele;

@SuppressWarnings("serial")
public class PSelect_suppr_modif_jeu_admin extends JPanel{
	private static JTable jeux;
	private JButton bmodif;
	private JButton bsuppr;
	private JButton bretour;
	private static Jeu jeuchoisi;
	private static ArrayList<Jeu> al;
	private static DefaultTableModel tableModel;
	
	public PSelect_suppr_modif_jeu_admin() {
		
		
		String[] colonnes= {"Nom","Genre","Prix","date",
				"editeur","plateforme","Note","Id"};
		tableModel = new DefaultTableModel(colonnes, 0);
		jeux=new JTable(tableModel);
		
		al= Jeu_modele.getJeuTous();
		
		for (int i = 0; i < al.size(); i++){
				int id=Jeu_modele.getId(al.get(i));
			   String nom = al.get(i).getNom();
			   String genre_nom = al.get(i).getGenre().getName();
			   
			   double prix = al.get(i).getPrix();
			   int date = al.get(i).getDate();
			   String editeur_nom = al.get(i).getEditeur().getName();
			   String plateforme_nom = al.get(i).getPlateforme().getName();
			   double note_20 = al.get(i).getNote().getNote_sur_20();
			 
			 

			   Object[] data = {nom, genre_nom, prix, date, editeur_nom,
					   			plateforme_nom , note_20,id};

			   tableModel.addRow(data);

			}
		
		
		
		
		bmodif=new JButton("Modifier");
		bsuppr=new JButton("Supprimer");
		bretour=new JButton("Retour");
		
		JScrollPane scrollPane = new JScrollPane(jeux);
		
		this.add(scrollPane);
		this.add(bretour);
		
		this.add(bmodif);
		this.add(bsuppr);
		
		/*jeux.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		       

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				jeuchoisi=Jeu_modele.getJeu(jeux.getSelectedRow()+1);
				System.out.println(jeux.getSelectedRow()+1);
				//(Integer)jeux.getValueAt(jeux.getSelectedRow(), 7)
			}
	    });*/
		
	
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
				
				int column = 7;
				int row = jeux.getSelectedRow();
				String value = jeux.getModel().getValueAt(row, column).toString();
				System.out.println(value);
				jeuchoisi=Jeu_modele.getJeu(Integer.parseInt(value));
				
				Fenetre.modif_jeu_admin=null;
				
				Fenetre.modif_jeu_admin=new PModif_jeu_admin(jeuchoisi.getNom(),
						Double.toString(jeuchoisi.getPrix()),
						Integer.toString(jeuchoisi.getDate()),
						jeuchoisi.getGenre().getName(),
						jeuchoisi.getEditeur().getName(),
						jeuchoisi.getPlateforme().getName(),
						Double.toString(jeuchoisi.getNote().getNote_sur_20()),
						Integer.toString(jeuchoisi.getNote().getNbre_votants()),
						jeuchoisi.getLienBoutique(),
						jeuchoisi.isDLC()
						);
				
				Fenetre.content.add(Fenetre.modif_jeu_admin,Fenetre.listcontent[7]);
				
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[7]);
			}
			
		});
		
		bsuppr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int column = 7;
				int row = jeux.getSelectedRow();
				String value = jeux.getModel().getValueAt(row, column).toString();
				System.out.println(value);
				
				jeuchoisi=Jeu_modele.getJeu(Integer.parseInt(value));
				if(jeuchoisi!=null) {
					jeuchoisi.supprJeu();
					
					al=Jeu_modele.getJeuTous();
					
					tableModel = new DefaultTableModel(colonnes, 0);
					
					for (int i = 0; i < al.size(); i++){
							System.out.println(al.get(i).getNom());
						   String nom = al.get(i).getNom();
						   String genre_nom = al.get(i).getGenre().getName();
						   int id=Jeu_modele.getId(al.get(i));
						   double prix = al.get(i).getPrix();
						   int date = al.get(i).getDate();
						   String editeur_nom = al.get(i).getEditeur().getName();
						   String plateforme_nom = al.get(i).getPlateforme().getName();
						   double note_20 = al.get(i).getNote().getNote_sur_20();
						 
						 

						   Object[] data = {nom, genre_nom, prix, date, editeur_nom,
								   			plateforme_nom , note_20,id};

						   tableModel.addRow(data);

						}
					
					Fenetre.resultats.getJeux().setModel(tableModel);
					Fenetre.select_suppr_modif_jeu_admin.getJeux().setModel(tableModel);
					tableModel.fireTableDataChanged();
				
					Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[4]);
				}
			}
			
		});
		
	}

	public static void setJeux(JTable jTable) {
		// TODO Auto-generated method stub
		jeux=jTable;
	}

	public JTable getJeux() {
		// TODO Auto-generated method stub
		return jeux;
	}

	public static Jeu getJeuchoisi() {
		return jeuchoisi;
	}

	public static void setJeuchoisi(Jeu jeuchoisi) {
		PSelect_suppr_modif_jeu_admin.jeuchoisi = jeuchoisi;
	}

	public static ArrayList<Jeu> getAl() {
		return al;
	}

	public static void setAl(ArrayList<Jeu> al) {
		PSelect_suppr_modif_jeu_admin.al = al;
	}

	public static DefaultTableModel getTableModel() {
		return tableModel;
	}

	public static void setTableModel(DefaultTableModel tableModel) {
		PSelect_suppr_modif_jeu_admin.tableModel = tableModel;
	}
	
	
}
