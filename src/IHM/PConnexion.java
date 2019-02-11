package IHM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PConnexion extends JPanel{
	private JButton bconnexion; 
	private JLabel lab_nom_user;
	private JLabel lab_mdp;
	private JTextField tf_nom_user;
	private JTextField tf_mdp;
	
	
	public PConnexion() {
		bconnexion = new JButton("Connexion");
		lab_nom_user=new JLabel("Nom d'utilisateur : ");
		lab_mdp=new JLabel("Mot de passe : ");
		tf_nom_user=new JTextField();
		tf_mdp=new JTextField();
		
		tf_nom_user.setPreferredSize(new Dimension(100,20));
		tf_mdp.setPreferredSize(new Dimension(100,20));
		
		
		this.add(lab_nom_user);
		this.add(tf_nom_user);
		this.add(lab_mdp);
		this.add(tf_mdp);
		this.add(bconnexion);
		
		bconnexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fenetre.cl.show(Fenetre.content, Fenetre.listcontent[4]);
			}
			
		});
		
	}
}
