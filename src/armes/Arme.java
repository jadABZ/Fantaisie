package armes;
import protagonistes.*;

public abstract class Arme {
	//pas besoin de methodes abstraites ici car on oblige pas les classes filles
	//d'implementer une classe dans Arme. On veut juste interdir l'instantiation de Arme.
	private Homme proprietaire;
	private String nature;
	private int degats;
	
	public Arme(String nature, int degats) {
		
		this.nature = nature;
		this.degats = degats;
	}

	public Homme getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Homme proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getNature() {
		return nature;
	}
	
	public boolean estPris()
	{
		return (this.proprietaire != null);
	}
	
	public void lacher()
	{
		this.proprietaire=null;
	}
	
	public String attaque(Dragon dragon)
	{
		String attaquer = this.proprietaire.getNom() + " attaque " + dragon.getNom() + " avec son " + this.nature +"\n";
		return attaquer + dragon.subirAttaque(this.degats);
	}

}
