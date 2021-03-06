package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Jeu.Jeu;
import Model.Jeu_modele;
import Model.Reservation_modele;
import Model.Utilisateur_modele;


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
	private JLabel lab_url;
	
	private Jeu jv;
	
	
	
	public PFiche_jeu() {
		jv=PResultats_user.getJeuchoisi();
		if(jv!=null) {
			System.out.println("panneau fiche chang�");
			breserver = new JButton("R�server");
			bretour = new JButton("Retour");
			lab_nom=new JLabel("Nom : "+jv.getNom());
			lab_prix=new JLabel("Prix : "+Double.toString(jv.getPrix()));
			lab_genre=new JLabel("Genre : "+jv.getGenre().getName());
			lab_date=new JLabel("Date de sortie : "+Integer.toString(jv.getDate()));
			lab_note_sur_20=new JLabel("Note : "+Double.toString(
					jv.getNote().getNote_sur_20()));
			lab_nbre_votants=new JLabel("Nombre de votants : "+
					Integer.toString(jv.getNote().getNbre_votants()));
			lab_editeur=new JLabel("Editeur : "+jv.getEditeur().getName());
			lab_plateforme=new JLabel("Plateforme : "+jv.getPlateforme().getName());
			lab_url=new JLabel("URL :"+jv.getLienBoutique());
		}
		else {
			breserver = new JButton("R�server");
			bretour = new JButton("Retour");
			lab_nom=new JLabel("Nom : ");
			lab_prix=new JLabel("Prix : ");
			lab_genre=new JLabel("Genre : ");
			lab_date=new JLabel("Date de sortie : ");
			lab_note_sur_20=new JLabel("Note : ");
			lab_nbre_votants=new JLabel("Nombre de votants : ");
			lab_editeur=new JLabel("Editeur : ");
			lab_plateforme=new JLabel("Plateforme : ");
			lab_url=new JLabel("URL :");
		}
			

		
		this.add(bretour);
		this.add(lab_nom);
		this.add(lab_prix);
		this.add(lab_genre);
		this.add(lab_date);
		this.add(lab_note_sur_20);
		this.add(lab_nbre_votants);
		this.add(lab_editeur);
		this.add(lab_plateforme);
		this.add(lab_url);
		this.add(breserver);
		
		breserver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!(Reservation_modele.estenBD(
						Jeu_modele.getId(jv), Utilisateur_modele.getId(
								PConnexion.getUnom())))) {
					Reservation_modele.ajoutReservation(Jeu_modele.getId(jv),
							Utilisateur_modele.getId(
									PConnexion.getUnom()));
					JOptionPane.showMessageDialog(PFiche_jeu.this,
							"Jeu r�serv� !","Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(PFiche_jeu.this,
							"Jeu d�j� r�serv� !","Erreur",
							JOptionPane.ERROR_MESSAGE);
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
