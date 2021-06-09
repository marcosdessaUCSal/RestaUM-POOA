import java.awt.EventQueue;

import controller.Controller;
import guiView.GUIstart;
import view.ConsoleView;
import view.View;

public class Principal {
	
	private static Controller controller;
	
	private static View view;

	public static void main(String[] args) {
		
		controller = new Controller();
		
//		view = new ConsoleView(controller);
		new GUIstart(controller);
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUIstart gui = new GUIstart(controller);
				gui.setVisible(true);
			}
		});
		

	}

}
