package protagonistes;

import affrontement.Bataille;
import armes.*;

public class Homme extends EtreVivant {
	
	private Arme maPossession;

	public Homme(String nom) {
		super(nom, 100);
	}
	
	public String parler(String phrase)
	{
		return this.nom + ": " + phrase + "\n";
	}
	
	public String rejointBataille(Bataille bataille)
	{
		this.bataille = bataille;
		return this.bataille.ajouter(this);
	}
	
	public String mourir()
	{
		String mort = "c'est ainsi que le courageux " + this.nom + " mourut\n";
		
		if(this.maPossession != null)
			return lacher() + mort + bataille.eliminer(this);
		else
			return mort + bataille.eliminer(this);
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
	
	public String lacher()
	{
		if(this.maPossession != null)
		{
			String lache = this.nom + " a laché son " + maPossession.getNature()+"\n"; //retourner cette chaine
			this.maPossession.lacher(); //prevenir l'arme qu'elle a ete lachee
			this.maPossession = null; //affecter null à l'attribut maPossession
			return lache;
		}
		
		return "Personne ne peut lacher cette arme car personne ne la possede\n";
	}
	
	public String prendre(Arme arme)
	{
		String discoursPrendre = "";
		if(this.maPossession != null) //si l’homme en possède déjà une, de la lâcher,
			discoursPrendre += lacher();
		
		if(arme.estPris()) //si l’arme est déjà la possession d’un autre homme,
		{
			discoursPrendre += this.parler("Peux-tu me laisser ton " + arme.getNature() + "?"); //le lui demander en lui parlant
			discoursPrendre += arme.getProprietaire().parler("Pas de souci, cela me permettra de reprendre mon souffle.\n"); //Au propriétaire de répondre
			discoursPrendre += arme.getProprietaire().lacher(); //le propriétaire lâche l’arme
		}
		
		if(arme instanceof Epee)
			discoursPrendre += this.prendreEpee((Epee)arme);
		else
			discoursPrendre += this.parler("Je prends mon " + arme.getNature() + ".\n");
		
		if(this.vie > 0) //si l'homme est encore en vie si il prend une epee, car posseder un epee lui fait perdre 10 de sa vie
		{
			this.maPossession = arme; //maPossession est affectée par l’arme donnée en paramètre
			arme.setProprietaire(this); //on affecte le nouveau propriétaire à l’arme.
		}
		
		return discoursPrendre;
	}
	
	public String combattre(Dragon dragon)
	{
		String discoursCombattre = "";
		if(this.maPossession == null)
		{
			discoursCombattre += this.getNom() + " s'attaque sans aucune arme a " + dragon.getNom() + "\n";
			return discoursCombattre + this.mourir();
		}
		
		return this.maPossession.attaque(dragon);
	}
	
	public String prendreEpee(Epee epee)
	{
		String discoursPrendreEpee = "";
		this.vie -=10;
		discoursPrendreEpee += this.parler("Je prends l'epee meme si pour cela je dois perdre des forces");
		if(this.vie<=0)
		{
			discoursPrendreEpee = this.nom + " a voulu prendre l'epee mais son etat de fatique ne lui permettait pas cet ultime effort, il en est mort\n" + this.mourir();
		}
		
		return discoursPrendreEpee;
	}
}
