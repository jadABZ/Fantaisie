package test_fonctionnel;

import protagonistes.Dragon;
import protagonistes.Heros;
import protagonistes.Homme;

public class TestProtagonistes {
	public static void main(String[] args) {
		Homme homme = new Homme("Thomas");
		Heros heros = new Heros("Arthur");
		Dragon dragon = new Dragon("Dragonnet");

		System.out.print(homme.parler("Je suis " + homme.getNom() + ", un homme."));
		System.out.print(heros.parler("Je suis " + heros.getNom() + ", un heros."));
		System.out.print("Le dragon " + dragon.getNom() + ".");
	}

	// RESULAT :
	// Thomas : Je suis Thomas, un homme.
	// Le h�ros Arthur : Je suis Arthur, un heros.
	// Le dragon Dragonnet.

}
