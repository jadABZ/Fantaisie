package protagonistes;

import armes.Epee;

public class Heros extends Homme {

	public Heros(String nom) {
		super(nom);
		this.vie=150;
	}
	
	public String parler(String phrase)
	{
		return "Le heros " + this.nom + ": " + phrase;
	}
	
	public String prendreEpee(Epee epee)
	{
		return this.parler("je prends " + epee.getNom()) + "\n";
	}

}
