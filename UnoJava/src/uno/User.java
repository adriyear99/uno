package uno;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	public static int id=0;
	public String nome;
	public ArrayList<Carta> hand = new ArrayList<Carta>();
	
	/* Getters e Setters */
	public int getId() {
		return id;
	}
	public static void setId(int idt) {
		id = idt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHand() {
		return hand.size();
	}
	public void setHand(ArrayList<Carta> hand) {
		this.hand = hand;
	}

	/* Construtor */
	public User(String n) {
		id++;
		nome = n;
		
		for(int i=0;i<7;i++) {
			hand.add(Deck.sort());
		}
	}
	
	/* Métodos principais */
	
	// Puxa uma carta
	public void draw(Deck deck) {
		if(Game.round == 1) {
		}
	}
	
	// Turno do jogador
	public void turn(Pile pilha, int num) {
		
		int cartaSelecionada = -1;
		System.out.println("");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		// Adiciona cartas à mão do jogador até ter alguma válida
		checkHand(pilha,num);
		
		// Verifica se a pessoa digitou um número fora do limite de cartas na mão
		while(cartaSelecionada < 0 || cartaSelecionada > hand.size()-1) {
			
			// Jogador seleciona carta da mão
			System.out.print("\nEscolha uma carta: ");
			cartaSelecionada = scan.nextInt();
		}
			
		// Verifica a carta escolhida até que seja escolhida uma opção válida
		while(!Game.verify(hand.get(cartaSelecionada),pilha)) {
			cartaSelecionada = scan.nextInt();
		}
			
			
		// Carta é tirada da mão e adicionada à pilha
		Carta cartaRemovida = hand.remove(cartaSelecionada);
		pilha.stack.add(cartaRemovida);
		checkCard(pilha,num);
	}
	
	// Reinicia o índice de cada usuário no banco de dados
	public static void restartID() {
		id = 0;
	}
	
	// Mostrar cartas na mão do jogador
	public void showHand(int num) {
		System.out.printf("Jogador %d\n",num);
		for(int i=0;i<hand.size();i++) {
			String v = hand.get(i).valor;
			String c = hand.get(i).cor;
			System.out.printf("%s %s | ",v,c);
		}
	}
	
	// Verifica se alguma carta na mão do jogador é válida
	public boolean checkHand(Pile pilha, int num) {
		for(int i=0;i<hand.size();i++) {
			if(Game.verify(hand.get(i),pilha)) {
				return true;
			}
		}
		
		hand.add(Deck.sort());
		showHand(num);
		return checkHand(pilha,num);
	}
	
	// Ativa ações de cartas especiais
	public void checkCard(Pile pilha, int num) {
		
		// Verifica se a carta adicionada é de utilidade (mudar com ou sem +4)
		if(pilha.topCard().cor == "null") {
			if(pilha.topCard().valor == "+4") {
				for(int i=0;i<4;i++) {
					hand.add(Deck.sort());
				}
			}
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String choice = scan.next();
			switch(choice) {
				case "vermelho":
					pilha.topCard().cor = "vermelho";
					break;
				case "azul":
					pilha.topCard().cor = "azul";
					break;
				case "verde":
					pilha.topCard().cor = "verde";
					break;
				case "amarelo":
					pilha.topCard().cor = "amarelo";
					break;
				default:
					System.out.println("Escolhe certo porra");
			}
		}
		
		// Verifica se a carta adicionada possui efeito de pular turno do oponente
		if(pilha.topCard().valor == "switch" || pilha.topCard().valor == "block") {
			turn(pilha,num);
		}
		
		// Verifica se a carta adicionada faz com que o oponente puxe duas cartas
		if(pilha.topCard().valor == "+2") {
			for(int i=0;i<2;i++) {
				hand.add(Deck.sort());
			}
		}
	}
	
}
