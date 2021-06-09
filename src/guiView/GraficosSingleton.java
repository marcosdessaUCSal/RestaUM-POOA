package guiView;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/*
 * Esta classe singleton armazena todas as imagens obtidas
 * a partir de arquivos png (pasta 'assets')
 * Todas as figuras são invocadas daqui.
 */

public class GraficosSingleton {

	private static GraficosSingleton instance;

	// blocos de imagens
	private Image fig00;
	private Image fig01;
	private Image fig02;
	private Image fig03;
	private Image fig10;
	private Image fig11;
	private Image fig12;
	private Image fig13;
	private Image fig20;
	private Image fig21;
	private Image fig22;
	private Image fig30;
	private Image fig31;
	private Image fig32;
	private Image fig33;
	private Image fig41;
	private Image fig51;
	private Image fig61;
	private Image fig62;

	// map que relaciona números a objetos Image
	Map<Integer, Image> mapa;

	private GraficosSingleton() {
		// blocos de imagens
		fig00 = new ImageIcon(getClass().getResource("assets/fig00.png")).getImage();
		fig01 = new ImageIcon(getClass().getResource("assets/fig01.png")).getImage();
		fig02 = new ImageIcon(getClass().getResource("assets/fig02.png")).getImage();
		fig03 = new ImageIcon(getClass().getResource("assets/fig03.png")).getImage();
		fig10 = new ImageIcon(getClass().getResource("assets/fig10.png")).getImage();
		fig11 = new ImageIcon(getClass().getResource("assets/fig11.png")).getImage();
		fig12 = new ImageIcon(getClass().getResource("assets/fig12.png")).getImage();
		fig13 = new ImageIcon(getClass().getResource("assets/fig13.png")).getImage();
		fig20 = new ImageIcon(getClass().getResource("assets/fig20.png")).getImage();
		fig21 = new ImageIcon(getClass().getResource("assets/fig21.png")).getImage();
		fig22 = new ImageIcon(getClass().getResource("assets/fig22.png")).getImage();
		fig30 = new ImageIcon(getClass().getResource("assets/fig30.png")).getImage();
		fig31 = new ImageIcon(getClass().getResource("assets/fig31.png")).getImage();
		fig32 = new ImageIcon(getClass().getResource("assets/fig32.png")).getImage();
		fig33 = new ImageIcon(getClass().getResource("assets/fig33.png")).getImage();
		fig41 = new ImageIcon(getClass().getResource("assets/fig41.png")).getImage();
		fig51 = new ImageIcon(getClass().getResource("assets/fig51.png")).getImage();
		fig61 = new ImageIcon(getClass().getResource("assets/fig61.png")).getImage();
		fig62 = new ImageIcon(getClass().getResource("assets/fig62.png")).getImage();

		// construindo o mapeamento
		mapa = new HashMap<>();
		mapa.put(0, fig00);
		mapa.put(1, fig01);
		mapa.put(2, fig02);
		mapa.put(3, fig03);
		mapa.put(10, fig10);
		mapa.put(11, fig11);
		mapa.put(12, fig12);
		mapa.put(13, fig13);
		mapa.put(20, fig20);
		mapa.put(21, fig21);
		mapa.put(22, fig22);
		mapa.put(30, fig30);
		mapa.put(31, fig31);
		mapa.put(32, fig32);
		mapa.put(33, fig33);
		mapa.put(41, fig41);
		mapa.put(51, fig51);
		mapa.put(61, fig61);
		mapa.put(62, fig62);

	}

	/*
	 * Retorna a imagem correspondente ao código informado. Se não há
	 * correspondência, a resposta é null
	 */
	public Image getImageIcon(int i) {
		if (!mapa.containsKey(i)) {
			return null;
		} else {
			return this.mapa.get(i);
		}
	}

	public synchronized static GraficosSingleton getInstance() {
		if (instance == null) {
			instance = new GraficosSingleton();
		}
		return instance;
	}

}
