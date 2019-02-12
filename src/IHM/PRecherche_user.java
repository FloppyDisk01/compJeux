package IHM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Comparateur.Comparateur;
import Jeu.Editeur;
import Jeu.Genre;
import Jeu.Jeu;
import Jeu.Note;
import Jeu.Plateforme;

@SuppressWarnings("serial")
public class PRecherche_user extends JPanel{
	private JButton brecherche; 
	
	private JLabel lab_nom;
	private JTextField jtf_nom;
	private JTextField jtf_genre;
	private JLabel lab_genre;
	private JTextField jtf_plateforme;
	private JLabel lab_plateforme;
	private JTextField jtf_editeur;
	private JLabel lab_editeur;
	private JLabel lab_prix;
	private JTextField jtf_prix;
	private JLabel lab_note;
	private JTextField jtf_note;
	
	private JLabel lab_nb_votants;
	private JTextField jtf_nb_votants;
	
	private JRadioButton DLC;
	private JRadioButton Jeu;
	private ButtonGroup g;
	
	private static Comparateur comp;
	
	
	public PRecherche_user() {
		brecherche = new JButton("Recherche");
		
		lab_nom=new JLabel("Nom : ");
		lab_prix=new JLabel("Prix : ");
		jtf_prix=new JTextField();
		jtf_nom=new JTextField();
		
		jtf_nom.setPreferredSize(new Dimension(70,20));
		jtf_prix.setPreferredSize(new Dimension(70,20));
		lab_genre=new JLabel("Genre : ");
		lab_editeur=new JLabel("Editeur : ");
		lab_plateforme=new JLabel("Plateforme : ");
		lab_note=new JLabel("Note : ");
		lab_nb_votants=new JLabel("Nombre de votants : ");
		

		
		jtf_genre=new JTextField();
		
		
		jtf_plateforme=new JTextField();
		
		jtf_editeur=new JTextField();
		
		
		jtf_note=new JTextField();
		jtf_nb_votants=new JTextField();
		jtf_note.setPreferredSize(new Dimension(70,20));
		jtf_nb_votants.setPreferredSize(new Dimension(70,20));
		jtf_genre.setPreferredSize(new Dimension(70,20));
		jtf_plateforme.setPreferredSize(new Dimension(70,20));
		jtf_editeur.setPreferredSize(new Dimension(70,20));
		
		g=new ButtonGroup();
		DLC=new JRadioButton("DLC");
		Jeu=new JRadioButton("Jeu");
		g.add(Jeu);
		g.add(DLC);
		
		
		this.add(lab_nom);
		this.add(jtf_nom);
		this.add(lab_prix);
		this.add(jtf_prix);
		this.add(lab_genre);
		this.add(jtf_genre);
		this.add(lab_editeur);
		this.add(jtf_editeur);
		this.add(lab_plateforme);
		this.add(jtf_plateforme);
		this.add(lab_note);
		this.add(jtf_note);
		this.add(lab_nb_votants);
		this.add(jtf_nb_votants);
		this.add(Jeu);
		this.add(DLC);
		this.add(brecherche);
	
		
		brecherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				Jeu jvrecherche=new Jeu(jtf_nom.getText(),
						new Genre(jtf_genre.getText()),
						1900,
						new Editeur(jtf_editeur.getText()),
						new Plateforme(jtf_plateforme.getText()),
						new Note(Double.parseDouble(jtf_note.getText()),
								Integer.parseInt(jtf_nb_votants.getText()))
						,
						Double.parseDouble(jtf_prix.getText()),
						DLC.isSelected(),"URL");
				comp=new Comparateur(jvrecherche);
				
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[2]);
			}
			
		});
		
		
		
	}
	
	public static Comparateur getComp() {
		return comp;
	}
}
