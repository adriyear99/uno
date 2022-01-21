package uno;

public class Carta {
	
	public String valor;
	public String cor;
	
	public Carta(String v, String c){
		valor = v;
		cor = c;
	}
	
	// Fun��es de cartas especiais
	public void skip(Carta card, User player) {
		
		switch(card.valor) {
			// Cartas que pulam o turno do usu�rio
			case "switch":
			case "block":
				System.out.println("� seu turno novamente");
				break;
				
			// Carta que faz com que o usu�rio puxe duas cartas
			case "+2":
				System.out.println("Seu oponente vai puxar duas cartas");
				break;
				
			case "mudar":
				System.out.println("Escolha uma nova cor");
				
		}
	}

	
}
