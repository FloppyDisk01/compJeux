package IHM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PModif_jeu_admin extends JPanel{
	private JButton bannuler;
	private JButton bvalider;
	
	private JLabel lab_nom;
	private JTextField jtf_nom;
	
	private JLabel lab_prix;
	private JTextField jtf_prix;
	
	private JLabel lab_genre;
	private JComboBox<String> list_genre;
	private JTextField jtf_genre;
	
	private JLabel lab_editeur;
	private JComboBox<String> list_editeur;
	private JTextField jtf_editeur;
	
	private JLabel lab_plateforme;
	private JComboBox<String> list_plateforme;
	private JTextField jtf_plateforme;
	
	private JLabel lab_date;
	private JTextField jtf_date;
	
	private JLabel lab_note;
	private JComboBox<String> list_note;
	
	public PModif_jeu_admin() {
		bvalider=new JButton("Valider");
		bannuler=new JButton("Annuler");
		
		lab_nom=new JLabel("Nom : ");
		jtf_nom=new JTextField();
		
		lab_prix=new JLabel("Prix : ");
		jtf_prix=new JTextField();
		
		lab_date=new JLabel("Date (Année) : ");
		jtf_date=new JTextField();
		
		lab_genre=new JLabel("Genre : ");
		String[] items_genre= {};
		list_genre=new JComboBox<String>(items_genre);
		jtf_genre=new JTextField();
		
		lab_editeur=new JLabel("Editeur : ");
		String[] items_editeur= {};
		list_editeur=new JComboBox<String>(items_editeur);
		jtf_editeur=new JTextField();
		
		lab_plateforme=new JLabel("Plateforme : ");
		String[] items_plateforme= {};
		list_plateforme=new JComboBox<String>(items_plateforme);
		jtf_plateforme=new JTextField();
		
		lab_note=new JLabel("Note : ");
		String[] items_note= {};
		list_note=new JComboBox<String>(items_note);
		
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
		this.add(list_genre);
		this.add(jtf_genre);
		jtf_genre.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_editeur);
		this.add(list_editeur);
		this.add(jtf_editeur);
		jtf_editeur.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_plateforme);
		this.add(list_plateforme);
		this.add(jtf_plateforme);
		jtf_plateforme.setPreferredSize(new Dimension(100,20));
		
		this.add(lab_note);
		this.add(list_note);
		
		this.add(bannuler);
		this.add(bvalider);
		
		bvalider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[6]);
			}
			
		});
		
		bannuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[6]);
			}
			
		});
	}
}
