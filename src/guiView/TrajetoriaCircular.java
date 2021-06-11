package guiView;

/*
 * Define a TRAJETÓRIA CIRCULAR de um objeto, em função do tempo
 * Dados: 	x1, y1 -> centro da circunferência
 * 			omega  -> velocidade angular em radianos por milissegundos
 * 			t0     -> tempo inicial em milissegundos
 * Ao usar os métodos getters, informar o tempo atual em milissegundos
 */

public class TrajetoriaCircular {
	
	private double x, y;
	private double xc, yc;
	private double omega;
	private double r;
	private double t, t0;
	
	public void setParams(double xc, double yc, double omega, double r,
			double t, double t0) {
		this.xc = xc;
		this.yc = yc;
		this.omega = omega;
		this.r = r;
		this.t = t;
		this.t0 = t0;
	}

	public double getX(double t) {
		x = xc + r * Math.cos(omega * (t - t0));
		return x;
	}
	
	public double getY(double t) {
		y = yc - r * Math.sin(omega * (t - t0));
		return y;
	}
}
