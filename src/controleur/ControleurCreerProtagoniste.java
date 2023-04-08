package controleur;
import protagonistes.*;

public class ControleurCreerProtagoniste {
	
	private StockEtreVivant stockEtreVivant;
	
	public ControleurCreerProtagoniste(StockEtreVivant stockEtreVivant){
		this.stockEtreVivant = stockEtreVivant;
	}

	public void creerEtreVivant(TypeEtreVivant typeEtreVivant, String nom)
	{
		if(typeEtreVivant == TypeEtreVivant.HEROS)
		{
			Heros heros = new Heros(nom);
			this.stockEtreVivant.ajouterHeros(heros);
		}
		
		if(typeEtreVivant == TypeEtreVivant.HOMME)
		{
			Homme homme = new Homme(nom);
			this.stockEtreVivant.ajouterHomme(homme);
		}
		
		if(typeEtreVivant == TypeEtreVivant.DRAGON)
		{
			Dragon dragon = new Dragon(nom);
			this.stockEtreVivant.ajouterDragon(dragon);
		}
	}
}
