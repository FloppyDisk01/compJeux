package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PResultats_user extends JPanel{
	private JTable jeux;
	private JButton plus_infos;
	private JButton nouvelle_recherche;
	
	public PResultats_user() {
		jeux=new JTable();
		plus_infos=new JButton("+ d'infos");
		nouvelle_recherche=new JButton("Nouvelle Recherche");
		
		this.add(jeux);
		this.add(plus_infos);
		this.add(nouvelle_recherche);
		
		plus_infos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[3]);
			}
			
		});
		
		nouvelle_recherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[1]);
			}
			
		});
	}
}
