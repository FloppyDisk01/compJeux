package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PMenu_admin extends JPanel{
	
	private JButton bajouter_jeu;
	private JButton bsuppr_modif_jeu;
	private JButton brechercher;
	
	public PMenu_admin() {
		bajouter_jeu=new JButton("Ajouter un jeu");
		bsuppr_modif_jeu=new JButton("Supprimer/Modifier un jeu");
		brechercher=new JButton("Rechercher");
		
		this.add(bajouter_jeu);
		this.add(bsuppr_modif_jeu);
		this.add(brechercher);
		
		bajouter_jeu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bsuppr_modif_jeu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		brechercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}
