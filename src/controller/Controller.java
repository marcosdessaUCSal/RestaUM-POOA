package controller;

import model.TabuleiroModel;

public class Controller {
	
	private TabuleiroModel tabuleiro;

	public Controller() {
		this.tabuleiro= new TabuleiroModel();
	}
	
	public boolean[][] getTabuleiro() {
		return this.tabuleiro.getMatrizTab();
	}
	
	public void iniciarTab() {
		tabuleiro.iniciarTab();
	}
	
	public boolean getElemento (int linha, int coluna) {
		return tabuleiro.getElemento(linha, coluna);
	}
	
	public int getNumPedras() {
		return tabuleiro.getNumPedras();
	}
	
	public boolean isGameOver() {
		
		if (this.tabuleiro.getNumPedras() > 1 && this.tabuleiro.isJogoAtivo()) {
			return false;
		}
		return true;
	}
	
	public boolean venceu() {
		if (this.tabuleiro.getNumPedras() == 1) {
			return true;
		}
		return false;
	}
	
	public boolean mover(int lin1, int col1, int lin2, int col2) {
		if (lin1 < 0 || lin2 <0 || col1 < 0 || col2 < 0) {
			return false;
		}
		if (lin1 > 6 || lin2 > 6 || col1 > 6 || col2 > 6) {
			return false;
		}
		return this.tabuleiro.mover(lin1, col1, lin2, col2);
	}
	
	

}
