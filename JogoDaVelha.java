package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		char[][] jogoVelha = new char[3][3];
		boolean ganhou = false;
		int jogada = 1;
		int linha, coluna;
		char sinal;
		System.out.println("Jogador 1 = X");
		System.out.println("Jogador 2 = Y");

		for (int i = 0; i < jogoVelha.length; i++) {
			for (int j = 0; j < jogoVelha[i].length; j++) {
				jogoVelha[i][j] = ' ';
			}
		}

		while (!ganhou && jogada <= 9) {

			if (jogada % 2 == 1) { // jogador 1

				System.out.println("Vez do jogador 1. Escolha linha e coluna (1-3).");
				sinal = 'X';
			} else {

				System.out.println("Vez do jogador 2. Escolha linha e coluna (1-3).");
				sinal = 'Y';
			}
			while (true) { // Valida a Linha
				System.out.println("Digite a linha (1-3)");

				if (ler.hasNextInt()) {
					linha = ler.nextInt();

					if (linha >= 1 && linha <= 3) {
						break;
					} else {
						System.out.println("Número inválido!");
					}

				} else {
					System.out.println("Digite apenas números!");
					ler.next();
				}
			}

			while (true) { // Valida coluna
				System.out.println("Digite a coluna (1-3)");

				if (ler.hasNextInt()) {
					coluna = ler.nextInt();

					if (coluna >= 1 && coluna <= 3) {
						break;
					} else {
						System.out.println("Número inválido!");
					}

				} else {
					System.out.println("Digite apenas números!");
					ler.next();
				}
			}
			linha--;
			coluna--;

			// Validação De Posição jogo da velha

			if (jogoVelha[linha][coluna] == ' ') {
				jogoVelha[linha][coluna] = sinal;
				jogada++;
			} else {
				System.out.println("Essa posição já está ocupada!");
			}
			for (int i = 0; i < jogoVelha.length; i++) {
				for (int j = 0; j < jogoVelha[i].length; j++) {
					System.out.print("| " + jogoVelha[i][j] + " ");
				}
				System.out.println("|");
			}

			if (jogoVelha[0][0] == sinal && jogoVelha[0][1] == sinal && jogoVelha[0][2] == sinal) {
				ganhou = true;
			} else if (jogoVelha[1][0] == sinal && jogoVelha[1][1] == sinal && jogoVelha[1][2] == sinal) {
				ganhou = true;
			} else if (jogoVelha[2][0] == sinal && jogoVelha[2][1] == sinal && jogoVelha[2][2] == sinal) {
				ganhou = true;
			} else if (jogoVelha[0][0] == sinal && jogoVelha[1][1] == sinal && jogoVelha[2][2] == sinal) {
				ganhou = true;
			} else if (jogoVelha[2][0] == sinal && jogoVelha[1][1] == sinal && jogoVelha[0][2] == sinal) {
				ganhou = true;
			} else if (jogoVelha[0][0] == sinal && jogoVelha[1][0] == sinal && jogoVelha[2][0] == sinal) {
				ganhou = true;
			} else if (jogoVelha[0][1] == sinal && jogoVelha[1][1] == sinal && jogoVelha[2][1] == sinal) {
				ganhou = true;
			} else if (jogoVelha[0][2] == sinal && jogoVelha[1][2] == sinal && jogoVelha[2][2] == sinal) {
				ganhou = true;
			}

			if (ganhou) {
				System.out.println("Jogador " + sinal + " venceu!");
			}
		}

		if (!ganhou) {
			System.out.println("Empate!");
		}
		ler.close();

	}
	
}
