package Comparateur;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilisateur {
	public static boolean estenBD() {
		return true;
	}
	
	public static boolean estAdmin(String login, String mdp) {
		return true;
	}
	
	public static String sha_1(String s) {
		MessageDigest md = null;
		 
        try {
            md = MessageDigest.getInstance("SHA-1"); // SHA-1 generator instance
        } catch(NoSuchAlgorithmException e) {
            return "";
        }
 
        try {
            //8859_1 ou UTF-8
            md.update(s.getBytes("UTF-8")); // Message summary generation
        } catch(UnsupportedEncodingException e) {
            return "";
        }
 
        byte raw[] = md.digest(); // Message summary reception
 
        try{
            String hash = new String(org.apache.commons.codec.binary.Base64.encodeBase64(raw),"UTF-8");
            //String hash = new String(raw);
            return hash;
        }
        catch (UnsupportedEncodingException use){
            return "";
        }
	}
}
