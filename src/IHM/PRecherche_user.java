package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PRecherche_user extends JPanel{
	private JButton brecherche; 
	
	private JLabel lab_nom;
	private JComboBox<String> list_genre;
	private JLabel lab_genre;
	private JComboBox<String> list_plateforme;
	private JLabel lab_plateforme;
	private JComboBox<String> list_editeur;
	private JLabel lab_editeur;
	private JLabel lab_prix;
	private JTextField jtf_prix;
	private JLabel lab_note;
	private JComboBox<String> list_note;
	
	private JRadioButton DLC;
	private JRadioButton Jeu;
	private ButtonGroup g;
	
	
	public PRecherche_user() {
		brecherche = new JButton("Recherche");
		
		lab_nom=new JLabel("Nom : ");
		lab_prix=new JLabel("Prix : ");
		jtf_prix=new JTextField();
		lab_genre=new JLabel("Genre : ");
		lab_editeur=new JLabel("Editeur : ");
		lab_plateforme=new JLabel("Plateforme : ");
		lab_note=new JLabel("Note : ");

		String[] items_genre= {};
		list_genre=new JComboBox<String>(items_genre);
		
		String[] items_plateforme= {};
		list_plateforme=new JComboBox<String>(items_plateforme);
		
		String[] items_editeur= {};
		list_editeur=new JComboBox<String>(items_editeur);
		
		String[] items_note= {"1","2","3","4","5","6","7","8","9","10","11"
				,"12","13","14","15","16","17","18","19","20"};
		list_note=new JComboBox<String>(items_note);
		
		g=new ButtonGroup();
		DLC=new JRadioButton("DLC");
		Jeu=new JRadioButton("Jeu");
		g.add(Jeu);
		g.add(DLC);
		
		this.add(brecherche);
		this.add(lab_nom);
		this.add(lab_prix);
		this.add(jtf_prix);
		this.add(lab_genre);
		this.add(list_genre);
		this.add(lab_editeur);
		this.add(list_editeur);
		this.add(lab_plateforme);
		this.add(list_plateforme);
		this.add(lab_note);
		this.add(list_note);
		this.add(Jeu);
		this.add(DLC);
		
		

	
		
		brecherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
	}
}
