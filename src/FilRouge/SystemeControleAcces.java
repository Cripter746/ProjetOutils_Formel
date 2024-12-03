package FilRouge;

public class SystemeControleAcces {
	//Etats possibles du systeme
	enum Etat {
		INITIAL,
		VERIFICATION_CARTE,
		ACCES_ACCORDE,
		ALARM
	}
	
	//Simplification des regles avec l'Algebre de boole
	static boolean carteValide(String carte){
		
		return carte.equalsIgnoreCase("valide");	//la carte valide	
	}
	
	static boolean codeCorrect(String code) {
		return code.equals("2003"); //le code de vérification
		
	}
	static class Automate {
		private Etat etatActuel;
		public Automate() {
			this.etatActuel = Etat.INITIAL; //Etat initial
		}
		//transition en fonction des regles logiques 
		public void transitionCarte(String carte) {
			if(etatActuel == Etat.INITIAL) {
				if(carteValide(carte)) {
					etatActuel = Etat.VERIFICATION_CARTE;
					
					System.out.println("Carte Valide. Transition vers vérification du code.");
				}else {
					etatActuel = Etat.ALARM;
					System.out.println("Carte invalide. Alarme déclenchée!!");
				}
			}else {
				System.out.println("L'Etat actuel n'autorise pas une nouvelle vérification de carte.");
			}
		}
		public void transitionCode(String code) {
			if(etatActuel == Etat.VERIFICATION_CARTE) {
				if(codeCorrect(code)) {
					etatActuel = Etat.ACCES_ACCORDE;
					System.out.println("Félicitaion ! l'accès est accordé");
				}else {
					etatActuel = Etat.ALARM;
					System.out.println("Code incorrect. Alarme déclenchée!!");
				}
			}else {
				System.out.println("L'Etat actuel n'autorise pas une nouvelle vérification de carte.");
			}
		}
		public void reinitialiser() {
			etatActuel = Etat.INITIAL;
			System.out.println("Système remis à l'etat initial.");
		}
		/**
		 * @return the etatActuel
		 */
		public Etat getEtatActuel() {
			return etatActuel;
		}
		
	}
}
