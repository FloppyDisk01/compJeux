package IHM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Jeu.Jeu;
import Jeu.Editeur;
import Jeu.Genre;
import Jeu.Note;
import Jeu.Plateforme;
import Model.Jeu_modele;

@SuppressWarnings("serial")
public class PAjout_jeu_admin extends JPanel{
	private JButton bannuler;
	private JButton bvalider;
	
	private JLabel lab_nom;
	private JTextField jtf_nom;
	
	private JLabel lab_prix;
	private JTextField jtf_prix;
	
	private JLabel lab_genre;
	private JTextField jtf_genre;
	
	private JLabel lab_editeur;
	private JTextField jtf_editeur;
	
	private JLabel lab_plateforme;
	private JTextField jtf_plateforme;
	
	private JLabel lab_date;
	private JTextField jtf_date;
	
	private JLabel lab_note;
	private JTextField jtf_note;
	
	private JLabel lab_nb_votants;
	private JTextField jtf_nb_votants;
	
	private JLabel lab_url;
	private JTextField jtf_url;
	
	private ButtonGroup g;
	private JRadioButton DLC;
	private JRadioButton Jeu;
	
	
	
	
	public PAjout_jeu_admin() {
		bvalider=new JButton("Valider");
		bannuler=new JButton("Annuler");
		
		lab_nom=new JLabel("Nom : ");
		jtf_nom=new JTextField();
		
		lab_prix=new JLabel("Prix : ");
		jtf_prix=new JTextField();
		
		lab_date=new JLabel("Date (Ann�e) : ");
		jtf_date=new JTextField();
		
		lab_genre=new JLabel("Genre : ");
		
		jtf_genre=new JTextField();
		
		lab_editeur=new JLabel("Editeur : ");
		
		jtf_editeur=new JTextField();
		
		lab_plateforme=new JLabel("Plateforme : ");
		
		jtf_plateforme=new JTextField();
		
		lab_note=new JLabel("Note : ");
		jtf_note=new JTextField();
		
		lab_nb_votants=new JLabel("Nombre votants : ");
		jtf_nb_votants=new JTextField();
		
		lab_url=new JLabel("Url : ");
		jtf_url=new JTextField();
		
		g=new ButtonGroup();
		DLC=new JRadioButton("DLC");
		Jeu=new JRadioButton("Jeu");
		g.add(Jeu);
		g.add(DLC);
		
		
		
		
		this.add(lab_nom);
		this.add(jtf_nom);
		jtf_nom.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_prix);
		this.add(jtf_prix);
		jtf_prix.setPreferredSize(new Dimension(70,20));
		
		this.add(lab_date);
		this.add(jtf_date);
		jtf_date.setPreferredSize(new Dimension(40,20));
		
		this.add(lab_genre);
		this.add(jtf_genre);
		jtf_genre.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_editeur);
		
		this.add(jtf_editeur);
		jtf_editeur.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_plateforme);
		
		this.add(jtf_plateforme);
		jtf_plateforme.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_note);
		this.add(jtf_note);
		jtf_plateforme.setPreferredSize(new Dimension(40,20));
		
		this.add(lab_nb_votants);
		this.add(jtf_nb_votants);
		jtf_plateforme.setPreferredSize(new Dimension(70,20));
		
		this.add(lab_url);
		this.add(jtf_url);
		jtf_plateforme.setPreferredSize(new Dimension(100,20));
		
		jtf_note.setPreferredSize(new Dimension(100,20));
		jtf_nb_votants.setPreferredSize(new Dimension(100,20));
		jtf_url.setPreferredSize(new Dimension(100,20));
		
		this.add(DLC);
		this.add(Jeu);
		
		this.add(bannuler);
		this.add(bvalider);
		
		bvalider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				String nom=jtf_nom.getText();
				double prix=Double.parseDouble(jtf_prix.getText());
				int date =Integer.parseInt(jtf_date.getText());
				double note =Double.parseDouble(jtf_note.getText());
				int nb_votants= Integer.parseInt(jtf_nb_votants.getText());
				Editeur editeur=new Editeur( jtf_editeur.getText());
				Genre genre= new Genre(jtf_genre.getText());
				Plateforme plateforme= new Plateforme(
						jtf_plateforme.getText());
				String url=jtf_url.getText();
				boolean estDLC=DLC.isSelected();
				
				Note no=new Note(note,nb_votants);
				
				Jeu jvajout=new Jeu(nom, genre,date,editeur,
						plateforme, no, prix, estDLC,url);
				System.out.println(jvajout);
				
				
				jvajout.ajoutJeu();
				
				JOptionPane.showMessageDialog(PAjout_jeu_admin.this,
						"Jeu ajout� !","Info",
						JOptionPane.INFORMATION_MESSAGE);
				
				
				
				DefaultTableModel tableModel = new DefaultTableModel();
				tableModel.addColumn("Nom");
				tableModel.addColumn("Genre");
				tableModel.addColumn("Prix");
				tableModel.addColumn("date");
				tableModel.addColumn("editeur");
				tableModel.addColumn("plateforme");
				tableModel.addColumn("Note");
				tableModel.addColumn("Id");
				
				ArrayList<Jeu> al=Jeu_modele.getJeuTous();
				for (int i = 0; i < al.size(); i++){
						
					   String nomal = al.get(i).getNom();
					   String genre_nom = al.get(i).getGenre().getName();
					   int id=Jeu_modele.getId(al.get(i));
					   double prixal = al.get(i).getPrix();
					   int dateal = al.get(i).getDate();
					   String editeur_nom = al.get(i).getEditeur().getName();
					   String plateforme_nom = al.get(i).getPlateforme().getName();
					   double note_20 = al.get(i).getNote().getNote_sur_20();
					  
					 
					 

					   Object[] data = {nomal, genre_nom, prixal, dateal, editeur_nom,
							   			plateforme_nom , note_20,id};

					   tableModel.addRow(data);

					}
				
				
				Fenetre.resultats.getJeux().setModel(tableModel);
				Fenetre.select_suppr_modif_jeu_admin.getJeux().setModel(tableModel);
				tableModel.fireTableDataChanged();
				
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[4]);
			}
			
		});
		
		bannuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[4]);
			}
			
		});
	}
	

}
