package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelhaComMetodo {
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		char[][] jogoVelha = new char[3][3];
		boolean ganhou = false;
		int jogada = 1;
		int linha, coluna;
		char sinal;

		System.out.println("Jogador 1 = X");
		System.out.println("Jogador 2 = Y");

		inicializarTabuleiro(jogoVelha);

		while (!ganhou && jogada <= 9) {

			if (jogada % 2 == 1) {
				System.out.println("Vez do jogador 1");
				sinal = 'X';
			} else {
				System.out.println("Vez do jogador 2");
				sinal = 'o';
			}

			linha = lerLinha(ler);
			coluna = lerColuna(ler);

			linha--;
			coluna--;

			if (jogoVelha[linha][coluna] == ' ') {
				jogoVelha[linha][coluna] = sinal;
				jogada++;
			} else {
				System.out.println("Essa posição já está ocupada!");
			}

			mostrarTabuleiro(jogoVelha);

			ganhou = verificarVitoria(jogoVelha, sinal);

			if (ganhou) {
				System.out.println("Jogador " + sinal + " venceu!");
			}
		}

		if (!ganhou) {
			System.out.println("Empate!");
		}
	}

	// Inicializa tabuleiro
	public static void inicializarTabuleiro(char[][] jogoVelha) {
		for (int i = 0; i < jogoVelha.length; i++) {
			for (int j = 0; j < jogoVelha[i].length; j++) {
				jogoVelha[i][j] = ' ';
			}
		}
	}

	// Mostra tabuleiro
	public static void mostrarTabuleiro(char[][] jogoVelha) {
		for (int i = 0; i < jogoVelha.length; i++) {
			for (int j = 0; j < jogoVelha[i].length; j++) {
				System.out.print("| " + jogoVelha[i][j] + " ");
			}
			System.out.println("|");
		}
	}

	// Lê linha
	public static int lerLinha(Scanner ler) {
		int linha;

		while (true) {
			System.out.println("Digite a linha (1-3)");

			if (ler.hasNextInt()) {
				linha = ler.nextInt();

				if (linha >= 1 && linha <= 3) {
					return linha;
				} else {
					System.out.println("Número inválido!");
				}
			} else {
				System.out.println("Digite apenas números!");
				ler.next();
			}
		}
	}

	// Lê coluna
	public static int lerColuna(Scanner ler) {
		int coluna;

		while (true) {
			System.out.println("Digite a coluna (1-3)");

			if (ler.hasNextInt()) {
				coluna = ler.nextInt();

				if (coluna >= 1 && coluna <= 3) {
					return coluna;
				} else {
					System.out.println("Número inválido!");
				}
			} else {
				System.out.println("Digite apenas números!");
				ler.next();
			}
		}
	}

	// Verifica vitória
	public static boolean verificarVitoria(char[][] jogoVelha, char sinal) {

		if (jogoVelha[0][0] == sinal && jogoVelha[0][1] == sinal && jogoVelha[0][2] == sinal)
			return true;
		if (jogoVelha[1][0] == sinal && jogoVelha[1][1] == sinal && jogoVelha[1][2] == sinal)
			return true;
		if (jogoVelha[2][0] == sinal && jogoVelha[2][1] == sinal && jogoVelha[2][2] == sinal)
			return true;

		if (jogoVelha[0][0] == sinal && jogoVelha[1][0] == sinal && jogoVelha[2][0] == sinal)
			return true;
		if (jogoVelha[0][1] == sinal && jogoVelha[1][1] == sinal && jogoVelha[2][1] == sinal)
			return true;
		if (jogoVelha[0][2] == sinal && jogoVelha[1][2] == sinal && jogoVelha[2][2] == sinal)
			return true;

		if (jogoVelha[0][0] == sinal && jogoVelha[1][1] == sinal && jogoVelha[2][2] == sinal)
			return true;
		if (jogoVelha[2][0] == sinal && jogoVelha[1][1] == sinal && jogoVelha[0][2] == sinal)
			return true;

		return false;
	}
}