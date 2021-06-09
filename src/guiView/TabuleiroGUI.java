package guiView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.temporal.TemporalAccessor;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import view.View;

public class TabuleiroGUI extends JPanel {
	
	private final int ATRASO = 100;
	private final int PERIODO = 20;

	private GUImatrizModel guiMatrizModel;
	private Controller controller;
	private GraficosSingleton imagens;
	TrajetoriaCircular trajetCirc;

	private Timer timer;
	private Monitor monitor;

	private boolean selecionado;
	private int linSelec, colSelec;

	private boolean isGameOver;
	private boolean venceu;
	
	private long tempoInicial, tempoAgora;
	private int contador;
	private boolean acionaContador;

	// CONSTRUTOR
	public TabuleiroGUI(Controller controller) {
		
		// listener do mouse
		this.addMouseListener(new MouseClickHandler());

		this.controller = controller;
		this.guiMatrizModel = new GUImatrizModel();
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);
		this.imagens = GraficosSingleton.getInstance();
		this.trajetCirc = new TrajetoriaCircular();

		this.timer = new Timer();

		this.selecionado = false;

		this.isGameOver = false;
		this.venceu = false;
		
		this.tempoInicial = System.currentTimeMillis();
		this.contador = 0;
		this.acionaContador = false;
		monitor = new Monitor();
		timer.scheduleAtFixedRate(monitor, ATRASO, PERIODO);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		monitor.setGraphics(g);

		// ALGORITMO PARA DESENHO DO TABULEIRO
		int x, y;
		int elemento;

		for (int linha = 0; linha <= 13; linha++) {
			y = linha * 48;
			for (int coluna = 0; coluna <= 10; coluna++) {
				x = coluna * 48;
				elemento = guiMatrizModel.getElementoGrafico(linha, coluna);
				g.drawImage(this.imagens.getImageIcon(elemento), x, y, this);
				Toolkit.getDefaultToolkit().sync();
			}
		}
		desenharEliminadas(g);
		desenhaTrajetoria(g);
		g.setFont(new Font("Serif", Font.BOLD, 22));
//		g.drawString("Contagem: " + monitor.getTempo(), 20, 20);
		g.drawString("Contagem: " + this.contador, 20, 20);
		Toolkit.getDefaultToolkit().sync();

	}
	
	private void desenhaTrajetoria(Graphics g) {
		double xc = 236, yc = 232;
		double omega = 0.001;
		double r = 240;
		double t = System.currentTimeMillis();
		int x = (int) trajetCirc.getX(t);
		int y = (int) trajetCirc.getY(t);
		if (x > 200 && x < 280 && y > 300) {
			guiMatrizModel.setElemento(10, 5, 62);
			acionaContador = true;
		} else {
			if (acionaContador) {
				contador++;
				acionaContador = false;
			}
			guiMatrizModel.setElemento(10, 5, 61);
		}
		trajetCirc.setParams(xc, yc, omega, r, t, tempoInicial);
		g.drawImage(this.imagens.getImageIcon(2), x, y, this);
	}
	
	private void desenharEliminadas(Graphics g) {
		int num = 32 - controller.getNumPedras();
		if (num == 0) return;
		int l = 11, c = 0;
		int x, y;
		for (int i = 0; i < num; i++) {
			y = 48 * l;
			x = 48 * c;
			g.drawImage(this.imagens.getImageIcon(1), x, y, this);
			c++;
			if (c == 11) {
				c = 0; l++;
			}
		}
	}

	private class MouseClickHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int xPos = e.getX();
			int yPos = e.getY();
			
			// identificando linha e coluna
			int linha = (int) (yPos / 48);
			int coluna = (int) (xPos / 48);
			
			// clicou no restart?
			if (linha == 10 && coluna == 5) {
				controller.iniciarTab();
				sincronizarMatrizes();
//				tempoInicial = System.currentTimeMillis();
				contador = 0;
				repaint();
				return;
			}
			
			// Venceu??
			if (controller.venceu()) {
				JOptionPane.showMessageDialog(null, "Mestre!! Venceu!");
				return;
			}

			// Perdeu??
			if (controller.isGameOver()) {
				isGameOver = true;
				JOptionPane.showMessageDialog(null, "Perdeu, playboy!", "Game Over!", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			if (selecionado) {
				if (linSelec == linha && colSelec == coluna) {
					desmarcar(linha, coluna);
					return;
				}
				if (fazerJogada(linSelec, colSelec, linha, coluna)) {
					desmarcar(linSelec, colSelec);
					sincronizarMatrizes();
					repaint();
				} else {
					desmarcar(linSelec, colSelec);
					return;
				}
			} else {
				if (guiMatrizModel.getElementoGrafico(linha, coluna) != 1) {
					return;
				} else {
					marcar(linha, coluna);
				}
			}
		}

		private void desmarcar(int l, int c) {
			guiMatrizModel.setElemento(l, c, 01);
			selecionado = false;
			repaint();
		}

		private void marcar(int l, int c) {
			guiMatrizModel.setElemento(l, c, 51);
			selecionado = true;
			linSelec = l;
			colSelec = c;
			repaint();
		}

		private boolean fazerJogada(int lin1, int col1, int lin2, int col2) {
			return controller.mover(lin1 - 2, col1 - 2, lin2 - 2, col2 - 2);

		}

		private void sincronizarMatrizes() {
			for (int l = 2; l < 9; l++) {
				for (int c = 2; c < 9; c++) {
					if (guiMatrizModel.getElementoGrafico(l, c) <= 1) {
						if (controller.getElemento(l - 2, c - 2)) {
							guiMatrizModel.setElemento(l, c, 1);
						} else {
							guiMatrizModel.setElemento(l, c, 0);
						}
					}
				}
			}
		}
	}
	
	private class Monitor extends TimerTask {
		
		private Graphics grTimer;

		@Override
		public void run() {
			repaint();
		}
		
		public void setGraphics(Graphics g) {
			this.grTimer = g;
		}
		
		public int getTempo() {
			tempoAgora = (int) (System.currentTimeMillis() - tempoInicial) / 1000;
			return (int) tempoAgora;
		}
	}
}
