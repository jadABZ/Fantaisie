package protagonistes;

import affrontement.Bataille;

public class Dragon extends EtreVivant {
	
	private int nbBoulesFeu;
	private int degatsBouleFeu;
	
	public Dragon(String nom) {
		super(nom, 200);
		nbBoulesFeu = 10;
		degatsBouleFeu = 100;
	}
	
	public String rejointBataille(Bataille bataille)
	{
		this.bataille = bataille;
		return this.bataille.ajouter(this);
	}
	
	public String mourir()
	{
		String mort = "c'est ainsi que le dragon " + this.nom + " mourut " + "\n";
		return mort + this.bataille.eliminer(this);
	}
	
	public String subirAttaque(int forceAttaque)
	{
		this.vie-=forceAttaque;
		String subir = this.nom + " subit une violente attaque, ";
		if(vie > 0)
			subir += " mais il parvient a se relever\n";
		else
		{
			subir+= " trop violente pour survivre\n" + mourir();
		}
		return subir;
	}
	
	public String cracheBouleFeu(Homme homme)
	{
		if(nbBoulesFeu > 0)
		{
			this.nbBoulesFeu--;
			return this.getNom() + " crache une boule de feu sur " + homme.getNom() + "\n" + homme.subirAttaque(degatsBouleFeu);
		}
		
		return this.getNom() + " a voulu attaquer "+ homme.getNom() + " mais il n’avait plus de feu en lui.\n" + homme.getNom() + " a eu beaucoup de chance !\n";
	}
}
