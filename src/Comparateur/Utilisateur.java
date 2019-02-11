package Comparateur;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Model.Utilisateur_modele;

public class Utilisateur {
	
	private String nom;
	private static String mdp;
	
	public Utilisateur(String nom, String mdp) {
		super();
		this.nom = nom;
		Utilisateur.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		Utilisateur.mdp = mdp;
	}

	public boolean estenBD() {
		if(sha_1(mdp).equals( Utilisateur_modele.getMdp(this) ))
		return true;
		else return false;
	}
	
	public  boolean estAdmin() {
		if(Utilisateur_modele.estAdmin(this))
			return true;
		else return false;
	}
	
	public static String sha_1(String s) {
		MessageDigest mDigest=null;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] result = mDigest.digest(s.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
	}
}
