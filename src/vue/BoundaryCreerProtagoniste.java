package vue;
import controleur.ControleurCreerProtagoniste;
import protagonistes.TypeEtreVivant;

public class BoundaryCreerProtagoniste {

	private ControleurCreerProtagoniste controleur;
	
	public BoundaryCreerProtagoniste(ControleurCreerProtagoniste controleur) {
		this.controleur = controleur;
	}
	
	public void creerProtagoniste()
	{
		int choix;
		String nom;
		
		System.out.println("Quel type de personnage souhaitez-vous cr�er ?");
		System.out.println("1: HEROS\n2: HOMME\n3: DRAGON\n");
		
		do {
		choix = Clavier.entrerClavierInt();
		if(choix != 1 && choix !=2 && choix!=3)
			System.out.println("Vous devez entrer un nombre entre 1 et 3\n");
		}while(choix != 1 && choix !=2 && choix!=3);
		
		System.out.println("Comment souhaitez vous l'appeler\n");
		
		nom = Clavier.entrerClavierString();
		
			switch(choix) {
				case 1: controleur.creerEtreVivant(TypeEtreVivant.HEROS, nom);
						break;
				case 2: controleur.creerEtreVivant(TypeEtreVivant.HOMME, nom);
						break;
				case 3: controleur.creerEtreVivant(TypeEtreVivant.DRAGON, nom);
						break;
				default: System.out.println("Vous devez entrer un nombre entre 1 et 3\n");
			}
		
	}
}
