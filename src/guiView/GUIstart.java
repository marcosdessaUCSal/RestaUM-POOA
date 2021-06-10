package guiView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;

public class GUIstart extends JFrame {
	private TabuleiroGUI jogo;
	private BorderLayout layout;
	private JPanel painelBotoes;
	private JButton btnIniciar;
	private Controller controller;
	
	public GUIstart() {
		Controller controller = new Controller();
		jogo = new TabuleiroGUI(controller);
		layout = new BorderLayout();
		painelBotoes = new JPanel();
		btnIniciar = new JButton("Sobre");
		painelBotoes.add(btnIniciar);
		btnIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Autor: Marcos Dessa");
			}
		});
		
		initUI();
	}
	
	private void initUI() {
		this.setLayout(layout);
		this.add(jogo, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);
		this.setTitle("There can be only one!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(528, 756);
	}
}
