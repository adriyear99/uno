package uno;

public class Carta {
	
	public String valor;
	public String cor;
	
	public Carta(String v, String c){
		valor = v;
		cor = c;
	}
	
	// Funções de cartas especiais
	public void skip(Carta card, User player) {
		
		switch(card.valor) {
			// Cartas que pulam o turno do usuário
			case "switch":
			case "block":
				System.out.println("É seu turno novamente");
				break;
				
			// Carta que faz com que o usuário puxe duas cartas
			case "+2":
				System.out.println("Seu oponente vai puxar duas cartas");
				break;
				
			case "mudar":
				System.out.println("Escolha uma nova cor");
				
		}
	}

	
}
