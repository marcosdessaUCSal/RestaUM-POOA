package guiView;

public class GUImatrizModel {

	private int matrizIntGrafDefault[][];
	private int matrizIntGrafinicial[][];

	public GUImatrizModel() {
		this.confDefault();
		this.confInicial();
	}
	
	// atualiza a matriz
	public void atualizaMatriz() {
		
	}
	
	public int getElementoGrafico(int linha, int coluna) {
		return this.matrizIntGrafDefault[linha][coluna];
	}
	
	public int getElementoGraficoInicial(int linha, int coluna) {
		return this.matrizIntGrafinicial[linha][coluna];
	}
	
	public void setElemento(int linha, int coluna, int codigo) {
		this.matrizIntGrafDefault[linha][coluna] = codigo;
	}
	
	private void confDefault() {
		
		this.matrizIntGrafDefault = new int[][] {
			{03, 03, 03, 03, 03, 03, 03, 03, 03, 03, 03},
			{03, 03, 03, 10, 21, 21, 21, 11, 03, 03, 03},
			{03, 03, 03, 20, 01, 01, 01, 41, 03, 03, 03},
			{03, 10, 21, 30, 01, 01, 01, 32, 21, 11, 03},
			{03, 20, 01, 01, 01, 01, 01, 01, 01, 41, 03},
			{03, 20, 01, 01, 01, 00, 01, 01, 01, 41, 03},
			{03, 20, 01, 01, 01, 01, 01, 01, 01, 41, 03},
			{03, 12, 22, 31, 01, 01, 01, 33, 22, 13, 03},
			{03, 03, 03, 20, 01, 01, 01, 41, 03, 03, 03},
			{03, 03, 03, 12, 22, 22, 22, 13, 03, 03, 03},
			{03, 03, 03, 03, 03, 61, 03, 03, 03, 03, 03},
			{00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00}
		};

	}
	
private void confInicial() {
		
		this.matrizIntGrafinicial = new int[][] {
			{03, 03, 03, 03, 03, 03, 03, 03, 03, 03, 03},
			{03, 03, 03, 10, 21, 21, 21, 11, 03, 03, 03},
			{03, 03, 03, 20, 00, 00, 00, 41, 03, 03, 03},
			{03, 10, 21, 30, 00, 00, 00, 32, 21, 11, 03},
			{03, 20, 00, 00, 00, 00, 00, 00, 00, 41, 03},
			{03, 20, 00, 00, 00, 00, 00, 00, 00, 41, 03},
			{03, 20, 00, 00, 00, 00, 00, 00, 00, 41, 03},
			{03, 12, 22, 31, 00, 00, 00, 33, 22, 13, 03},
			{03, 03, 03, 20, 00, 00, 00, 41, 03, 03, 03},
			{03, 03, 03, 12, 22, 22, 22, 13, 03, 03, 03},
			{03, 03, 03, 03, 03, 03, 03, 03, 03, 03, 03},
			{02, 02, 02, 02, 02, 02, 02, 02, 02, 02, 02},
			{02, 02, 02, 02, 02, 02, 02, 02, 02, 02, 02},
			{02, 02, 02, 02, 02, 02, 02, 02, 02, 02, 00}
		};

	}

}
