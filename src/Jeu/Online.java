package Jeu;

public class Online {
	private int nombre_modes;
	private int nombre_joueurs_max;
	public Online(int nombre_modes, int nombre_joueurs_max) {
		
		this.nombre_modes = nombre_modes;
		this.nombre_joueurs_max = nombre_joueurs_max;
	}
	public int getNombre_modes() {
		return nombre_modes;
	}
	public void setNombre_modes(int nombre_modes) {
		this.nombre_modes = nombre_modes;
	}
	public int getNombre_joueurs_max() {
		return nombre_joueurs_max;
	}
	public void setNombre_joueurs_max(int nombre_joueurs_max) {
		this.nombre_joueurs_max = nombre_joueurs_max;
	}
	
	
}
