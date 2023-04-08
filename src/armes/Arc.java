package armes;

import protagonistes.Dragon;

public class Arc extends Arme {

	private int nombreFleche;
	
	public Arc(int nombreFleche) {
		super("arc", 30);
		this.nombreFleche = nombreFleche;
	}

	public String attaque(Dragon dragon)
	{
		String attaquer = this.getProprietaire().getNom() + " attaque " + dragon.getNom() + " avec son " + this.getNature() +"\n";
		if(this.nombreFleche <= 0)
			return attaquer + "Malheureusement il ne possedait plus de fleches\n";
		this.nombreFleche--;
		return super.attaque(dragon);
	}

	public int getNombreFleches() {
		return nombreFleche;
	}
}
