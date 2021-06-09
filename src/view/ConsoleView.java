package view;

import java.io.IOException;
import java.util.Scanner;

import controller.Controller;

public class ConsoleView implements View {

	private Scanner teclado;
	private Controller controller;
	private boolean[][] matrizTab;
	private int[] vMov; // vetor com as coordenadas das pedras, antes e depois

	// CONSTRUTOR
	public ConsoleView(Controller controller) {
		this.controller = controller;
		this.vMov = new int[4];
		teclado = new Scanner(System.in);

		while (!this.controller.venceu() || !this.controller.venceu()) {

			System.out.println("");
			this.desenharTabuleiro();
			this.escreverInfo();
			this.mover();
			if (this.controller.isGameOver()) {
				System.out.println("Jogo finalizado. Você perdeu!");
				this.desenharTabuleiro();
				break;
			}
			if (this.controller.venceu()) {
				System.out.println("Parabénsd!! Você venceu o jogo!");
				break;
			}

		}

	}

	private void desenharTabuleiro() {

		this.matrizTab = controller.getTabuleiro();

		System.out.println("       0 1 2 3 4 5 6");
		System.out.println("  ---------------------");
		for (int linha = 0; linha <= 6; linha++) {
			System.out.print("  " + linha + "    ");
			for (int coluna = 0; coluna <= 6; coluna++) {
				if (linha >= 2 && linha <= 4) {
					if (this.matrizTab[linha][coluna]) {
						System.out.print("o ");
					} else {
						System.out.print(". ");
					}
				}
				if (linha < 2 || linha > 4) {
					if (this.matrizTab[linha][coluna]) {
						System.out.print("o ");
					} else if (coluna < 2 || coluna > 4) {
						System.out.print("  ");
					} else {
						System.out.print(". ");
					}

				}
			}
			System.out.println("");
		}
		System.out.println("  ---------------------");

	}

	private void escreverInfo() {

		System.out.println("Número de peças: " + this.controller.getNumPedras());

	}

	private void mover() {
		boolean valido = false;

		while (!valido) {
			String s = null;
			System.out.println("Mover de:");
			s = teclado.nextLine();
			vMov[0] = s.charAt(0) - '0';
			vMov[1] = s.charAt(1) - '0';
			System.out.println("Mover para:");
			s = teclado.nextLine();
			vMov[2] = s.charAt(0) - '0';
			vMov[3] = s.charAt(1) - '0';
			
			System.out.println("Mover de (" + vMov[0] + ", " + vMov[1] + ") para (" + vMov[2] + ", " + vMov[3] + ")");
			
			valido = this.controller.mover(vMov[0], vMov[1], vMov[2], vMov[3]);
			if (!valido) {
				System.out.println("Movimento inválido. Digite novamente!");
			}
			
		}

	}

}
