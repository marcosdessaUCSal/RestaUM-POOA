import java.awt.EventQueue;

import controller.Controller;
import guiView.GUIstart;
import view.ConsoleView;
import view.View;

public class Principal {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUIstart gui = new GUIstart();
				gui.setVisible(true);
			}
		});
	}
}
