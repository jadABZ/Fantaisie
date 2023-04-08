package vue;

import java.util.*;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
    	int rep = -1;
    	//do {
    		try {
    			rep = scanner.nextInt();
    		}catch(InputMismatchException e)
    		{
    			System.out.println("Vous devez entrer un nombre\n");
    			scanner.next();
    			rep = entrerClavierInt();
    		}
    	//}while(rep ==-1);
        
    	return rep;
    }

    public static String entrerClavierString() {
        return scanner.next();
    }

}
