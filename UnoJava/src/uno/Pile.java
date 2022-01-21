package uno;

import java.util.ArrayList;

public class Pile {
	
	ArrayList<Carta> stack = new ArrayList<Carta>();
	
	public ArrayList<Carta> addToPile(Carta card) {
		stack.add(card);
		return stack;
	}
	
	public void showPile() {
		
		for(int i=0;i<stack.size();i++) {
			String v = stack.get(i).valor;
			String c = stack.get(i).cor;
			System.out.printf("%s %s\n",v,c);
		}
	}
	
	// Mostra na tela os atributos da última carta da pilha
	public void showTopCard() {
		String v = stack.get(stack.size() - 1).valor;
		String c = stack.get(stack.size() - 1).cor;
		System.out.printf("Carta no topo da pilha: %s %s\n\n",v,c);
	}
	
	// Retorna a última carta da pilha
	public Carta topCard() {
		return stack.get(stack.size() -1);
	}
	
	public void addToPile() {
		stack.add(Deck.sort());
	}

}
