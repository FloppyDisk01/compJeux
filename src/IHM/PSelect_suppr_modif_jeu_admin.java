package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PSelect_suppr_modif_jeu_admin extends JPanel{
	private JTable jeux;
	private JButton bmodif;
	private JButton bsuppr;
	private JButton bretour;
	
	public PSelect_suppr_modif_jeu_admin() {
		jeux=new JTable();
		bmodif=new JButton("Modifier");
		bsuppr=new JButton("Supprimer");
		bretour=new JButton("Retour");
		
		this.add(bretour);
		this.add(jeux);
		this.add(bmodif);
		this.add(bsuppr);
		
		
		bretour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bmodif.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bsuppr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}
