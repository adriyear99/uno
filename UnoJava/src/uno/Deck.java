package uno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
	
	/* Atributos */
	public static ArrayList<Carta> deck = new ArrayList<Carta>();

	
	/* Getters e setters */
	public static ArrayList<Carta> getDeck() {
		return deck;
	}

	public static void setDeck(ArrayList<Carta> d) {
		deck = d;
	}
	
	/* Métodos */
	
	// Mostrar tamanho do deck
	public static void deckSize() {
		System.out.println("\nCartas restantes no deck: " + deck.size());
	}
	
	// Carta aleatória a ser adicionada no primeiro round
	public static void firstDraw(Pile pilha) {
		Carta cartaPuxada = Deck.sort();
		pilha.stack.add(cartaPuxada);
	}
	
	// Preenche o deck com todas as cartas
	public static void fill() {
		
		// Array de cores
		ArrayList<String> cores = new ArrayList<>(Arrays.asList("vermelho","azul","verde","amarelo","null"));
		
		// Array de cartas especiais
		ArrayList<String> especiais = new ArrayList<>(Arrays.asList("+2","switch","block"));
		
		// Array de cartas de utilidade
		ArrayList<String> utilidade = new ArrayList<>(Arrays.asList("mudar","+4"));
		
		// Preencher o deck com cartas de 0 a 9 de cada cor
		for(int i=0; i<cores.size()-1; i++) {
			for(int j=0; j<10; j++) {
				if(j==0) {
					Carta elemento = new Carta(Integer.toString(j),cores.get(i));
					deck.add(elemento);
				} 
				else {
					for(int num=0;num<2;num++) {
						Carta elemento = new Carta(Integer.toString(j),cores.get(i));
						deck.add(elemento);
					}
				}
			}
		}
		
		// Preencher o deck com cartas especiais de cada cor
		for(int i=0;i<cores.size()-1;i++) {
			for(int j=0;j<especiais.size();j++) {
				for(int k=0;k<2;k++) {
					Carta elemento = new Carta(especiais.get(j),cores.get(i));
					deck.add(elemento);
				}
			}
		}
		
		// Preencher o deck com cartas de utilidade
		for(int i=0;i<utilidade.size();i++) {
			for(int j=0;j<4;j++) {
				Carta elemento = new Carta(utilidade.get(i),"null");
				deck.add(elemento);
			}
		}
		
		System.out.println("O deck foi preenchido com " + deck.size() + " cartas!");
		
	}
	
	// Mostra todas as cartas do deck
	public static void showDeck() {
		for(int i=0;i<deck.size();i++) {
			String valor = deck.get(i).valor;
			String cor = deck.get(i).cor;
			System.out.println(valor + " " + cor);
		}
	}
	
	// Seleciona uma carta aleatória a ser puxada
	public static Carta sort() {
		Random rand = new Random();
		int numAleatorio = rand.nextInt(deck.size());
		Carta cartaSelecionada = deck.get(numAleatorio);
		
		// Remove a carta selecionada do baralho
		deck.remove(numAleatorio);
		
		// Carta selecionada é adicionada à mão do jogador
		return cartaSelecionada;
	}
	
	
}
