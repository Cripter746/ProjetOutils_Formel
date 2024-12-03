package FilRouge;

import java.util.Scanner;

import FilRouge.SystemeControleAcces.Automate;
import FilRouge.SystemeControleAcces.Etat;

public class Mainly {

	public static void main(String[] args) {
		Automate  automate = new Automate();
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== Système de contrôle d'accès ===");
		
		boolean continuer = true;
		
		while(continuer) {
			System.out.println("\nMenu :");
			System.out.println("1. Entrer une carte ");
			System.out.println("2. Entrer un code");
			System.out.println("3. Reinitialiser le système");
			System.out.println("4. Quitter");
			System.out.println("Faite votre choix !");
			
			int choix= scanner.nextInt();
			scanner.nextLine();  //pour vider le buffer
			
			switch (choix) {
			case 1:
				System.out.println("Entrer le statut de la carte (valide / invalide) : ");
				String carte = scanner.next();
				scanner.nextLine();
				
				automate.transitionCarte(carte);
				break;
				
			case 2:
				if(automate.getEtatActuel() == Etat.VERIFICATION_CARTE) {
					System.out.println("Entrez le code Valide");
					String code = scanner.next();
					scanner.nextLine();
					
					automate.transitionCode(code);
				}else{
					System.out.println("Vous ne pouvez pas entrer un code dans l'Etat actuel.");
				};
				break;
			
			case 3:
				automate.reinitialiser();
				break;
				
			case 4:
				continuer = false;
				System.out.println("Système arrèté , à bientôt.");
				break;
				
			default:
				System.out.println("Choix invalide. Veuillez réesayer");
				
			}
		}scanner.close(); //Pour dire qu'on ne pourra plus utiliser scanner
	}

}
