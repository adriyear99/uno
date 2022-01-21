package swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uno.User;
import uno.Carta;

public class Jogo extends JFrame implements ActionListener{

	// Tela
	JPanel painel = new JPanel();
	
	// Componentes
	private JButton start = new JButton("Começar");
	private JButton sair = new JButton("Sair");
	private static JTextField texto = new JTextField("Digite seu nome de usuário",30);
	
	// Imagens
	JLabel imagem = new JLabel();
	
	// Variáveis de tela
	public static int cena = 0;
	
	
	// Método de ações
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==start) {
			String user = texto.getText();
			JOptionPane.showMessageDialog(null,"Usuário registrado no banco de dados.");
			painel.setVisible(false);
		}
		if(e.getSource()==sair) {
			// Fecha o jogo
			System.exit(0);
		}
	}
	
	
	public Jogo(int cena) {
		
		if(cena == 0) {
			// Definindo a tela do jogo
			setTitle("UNO");
			setSize(700,600);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setResizable(true);
			
			
			// Definindo componentes
			imagem.setIcon(new ImageIcon(getClass().getResource("logo.jpg")));
			
			painel.add(imagem);
			painel.add(texto);
			start.setBounds(100,100,100,60);
			painel.add(start);
			sair.setBounds(200,100,100,60);
			painel.add(sair);
			add(painel);
			validate();
			
//			// Painel
//			painel.setPreferredSize(new Dimension(500,400));
//			add(painel);
//			pack();
//			setLocationRelativeTo(null);
			
			int largura = getContentPane().getSize().width;
			int altura = getContentPane().getSize().height;
			
			// Ações ao clicar
			start.addActionListener(this);
			sair.addActionListener(this);
		}
		
		else if(cena == 1) {
			
		}

	
	}

	// Método principal do programa
	public static void main(String[] args) {
//		User p1 = new User(texto.getText());
//		User p2 = new User(texto.getText());
		new Jogo(cena);
	}
	
//	// Mostrar cartas na mão do jogador
//	public void showHand(int num, User player) {
//		System.out.printf("Jogador %d\n",num);
//		for(int i=0;i<player.hand.size();i++) {
//			String v = player.hand.get(i).valor;
//			String c = player.hand.get(i).cor;
//			System.out.printf("%s %s | ",v,c);
//		}
//	}

}
