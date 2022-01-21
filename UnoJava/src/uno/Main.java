package uno;

public class Main {

	public static void main(String[] args) {
		
		// Estruturas de cartas
		Pile pilha = new Pile();		// Inicializa a pilha
		Deck.fill();					// Preenche o deck
		
		// Jogadores
		User p1 = new User("Adriano");
		User p2 = new User("Matheus");

		// Primeiro round
		pilha.addToPile();				// Adiciona uma carta do deck à pilha
		pilha.showTopCard();			// Mostra a carta no topo da pilha

		
		// Game Loop
		while(Game.running(p1,p2)) {
			Game.showRound();
			
			// Primeiro jogador
			p1.showHand(1);
			p1.turn(pilha,1);
			pilha.showTopCard();
			
			// Segundo jogador
			p2.showHand(2);
			p2.turn(pilha,2);
			pilha.showTopCard();
			
			Game.endRound();
		}
		
	}

}
