package model;

public class TabuleiroModel {

	private int matrizTab[][];
	private int numPedras;

	public TabuleiroModel() {
		this.matrizTab = new int[7][7];
		this.iniciarTab();
	}

	public void iniciarTab() {

		// preencher o tabuleiro com as pedras
		for (int linha = 0; linha < 7; linha++) {
			for (int coluna = 0; coluna < 7; coluna++) {
				matrizTab[linha][coluna] = -1;
				if (linha >= 2 && linha <= 4) {
					this.matrizTab[linha][coluna] = 1;
				} else {
					if (coluna <= 1 || coluna >= 5) {
						this.matrizTab[linha][coluna] = -1;
					} else {
						this.matrizTab[linha][coluna] = 1;
					}
				}
			}
		}
		this.matrizTab[3][3] = 0;
		this.numPedras = 32;

	}

	/*
	 * IMPORTANTE. O jogo ainda está ativo (true) se houver pelo menos 1 movimento válido disponível.
	 * 			   Esta rotina procura algum movimento válido. No primeiro encontrado, retorna true.
	 * 			   Caso contrário, retorna false.
	 * 			   VÁLIDO: sequência true-true-false ou false-true-true
	 * 			   INVÁLIDO: qualquer outra coisa.
	 */
	public boolean isJogoAtivo() {
		
		int p1, p2, p3;
		
		// Busca na vertical
		for (int linha = 0; linha < 5; linha++) {
			for (int coluna = 0; coluna < 7; coluna++) {
				p1 = this.matrizTab[linha][coluna];
				p2 = this.matrizTab[linha + 1][coluna];
				p3 = this.matrizTab[linha + 2][coluna];
				if ((p1 == 1 && p2 == 1 && p3 == 0) || (p1 == 0 && p2 == 1 && p3 == 1))
					return true;	// achou uma jogada válida!
			}
		}
		
		// Busca na horizontal
		for (int linha = 0; linha < 7; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {
				p1 = this.matrizTab[linha][coluna];
				p2 = this.matrizTab[linha][coluna + 1];
				p3 = this.matrizTab[linha][coluna + 2];
				if ((p1 == 1 && p2 == 1 && p3 == 0) || (p1 == 0 && p2 == 1 && p3 == 1))
					return true;	// achou uma jogada válida!
			}
		}
		
		// Nenhum movimento válido restante. Fim de jogo!
		return false;
	}

	public boolean isMoviValido(int lin1, int col1, int lin2, int col2) {

		// fora da vertical ou horizontal?
		if (lin1 != lin2 && col1 != col2)
			return false;

		// fora do alcance?
		if ((lin1 == lin2) && Math.abs(col1 - col2) != 2)
			return false;
		if (Math.abs(lin1 - lin2) != 2 && (col1 == col2))
			return false;
		
		// destino fora do tabuleiro?
		if (this.matrizTab[lin2][col2] == -1) {
			return false;
		}

		// posição destino ocupada?
		if (this.matrizTab[lin2][col2] == 1)
			return false;

		// posição de origem vazia?
		if (this.matrizTab[lin1][col1] == 0)
			return false;

		// não há peça no meio?
		if (this.matrizTab[(lin1 + lin2) / 2][(col1 + col2) / 2] == 0)
			return false;

		// caso contrário, o movimento é válido
		return true;
	}

	public boolean mover(int lin1, int col1, int lin2, int col2) {

		// a jogada não é válida?
		if (!this.isMoviValido(lin1, col1, lin2, col2))
			return false;

		// efetuando a jogaga...
		this.matrizTab[lin1][col1] = 0;
		this.matrizTab[lin2][col2] = 1;
		this.matrizTab[(lin1 + lin2) / 2][(col1 + col2) / 2] = 0;

		// uma pedra eliminada:
		this.numPedras--;

		// jogada bem-sucedida
		return true;
	}

	// Só vai existir provisoriamente enquanto houver a interface de console
	public boolean[][] getMatrizTab() {
		boolean[][] matriz = new boolean[7][7];
		for (int l = 0; l < 7; l++) {
			for (int c = 0; c < 7; c++) {
				if (this.matrizTab[l][c] == 1) {
					matriz[l][c] = true;
				} else {
					matriz[l][c] = false;
				}
			}
		}
		return matriz;
	}

	public int getNumPedras() {
		return this.numPedras;
	}
	
	public boolean getElemento (int linha, int coluna) {
		return matrizTab[linha][coluna] == 1 ? true : false; 
	}

}













