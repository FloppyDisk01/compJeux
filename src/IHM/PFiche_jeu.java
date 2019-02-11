package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PFiche_jeu extends JPanel{
	private JButton breserver; 
	private JButton bretour; 
	private JLabel lab_nom;
	private JLabel lab_prix;
	private JLabel lab_genre;
	private JLabel lab_note_sur_20;
	private JLabel lab_nbre_votants;
	private JLabel lab_editeur;
	private JLabel lab_plateforme;
	private JLabel lab_date;
	
	
	public PFiche_jeu() {
		breserver = new JButton("Réserver");
		bretour = new JButton("Retour");
		lab_nom=new JLabel("Nom : ");
		lab_prix=new JLabel("Prix : ");
		lab_genre=new JLabel("Genre : ");
		lab_date=new JLabel("Date de sortie : ");
		lab_note_sur_20=new JLabel("Note : ");
		lab_nbre_votants=new JLabel("Nombre de votants : ");
		lab_editeur=new JLabel("Editeur : ");
		lab_plateforme=new JLabel("Plateforme : ");

		
		this.add(bretour);
		this.add(lab_nom);
		this.add(lab_prix);
		this.add(lab_genre);
		this.add(lab_date);
		this.add(lab_note_sur_20);
		this.add(lab_nbre_votants);
		this.add(lab_editeur);
		this.add(lab_plateforme);
		this.add(breserver);
		
		breserver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bretour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[2]);
			}
			
		});
		
	}

}
