package uno;

public class Game {
	
	/* Atributos */
	public static boolean run = true;
	public static int round = 1;
	
	/* M�todos */
	
	// Encerra o turno
	public static void endRound() {
		round++;
		System.out.println("\n");
	}
	
	// Mostra n�mero do turno
	public static void showRound() {
		System.out.printf("Round %d\n\n",round);
	}
	
	// Condi��o para o jogo continuar rodando
	public static boolean running(User p1, User p2) {
		
		if(p1.getHand() == 1 || p2.getHand() == 1 ) {
			System.out.println("UNO");
			return run;
		}
		else if(p1.getHand() == 0 || p2.getHand() == 0 ) {
			return !run;
		}
		
		return run;
	}
	
	// Condi��o de aceita��o da carta
	public static boolean verify(Carta card, Pile pilha) {
		String corPilha = pilha.topCard().cor;
		String valorPilha = pilha.topCard().valor;
		
		return (card.cor == corPilha || card.valor == valorPilha || card.cor == "null");
	}
}
