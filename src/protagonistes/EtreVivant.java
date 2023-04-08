package protagonistes;

import affrontement.Bataille;

public abstract class EtreVivant {
	protected String nom;
	protected int vie;
	protected Bataille bataille;
	
	public EtreVivant(String nom, int vie)
	{
		this.nom=nom;
		this.vie=vie;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	//en utilisant le methodes abstraites, on evite d'ecrire des corps inutiles pour ces methodes
	//mais on oblige les classes filles a les implementer 
	public abstract String rejointBataille(Bataille bataille);
	public abstract String mourir(); 
	
	public String subirAttaque(int forceAttaque)
	{
		String subir = this.nom + " subit une violente attaque, ";
		this.vie-=forceAttaque;
		if(vie > 0)
			subir += " mais il parvient a se relever\n";
		else
		{
			subir+= " trop violente pour survivre\n";
			mourir();
		}
		
		return subir;
	}
	
}
