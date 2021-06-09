package guiView;

/*
 * Define a TRAJETÓRIA RETILÍNEA de um objeto, em função do tempo
 * Dados: 	x1, y1 -> posição inicial
 * 			x2, y2 -> posição final
 * 			v      -> velocidade em pixels por milissegundo
 * 			t0     -> tempo inicial em milissegundos
 * Ao usar os métodos getters, informar o tempo atual em milissegundos
 */

public class TrajetoriaLinear {
	
	private double x, y;
	private double x1, y1;
	private double x2, y2;
	private double ux, uy;
	private double l;
	private double v;
	private double t, t0;
	private double dt;
	
	public TrajetoriaLinear(double x1, double y1, double x2, double y2,
			double v, double t0) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.v = v;
		this.t0 = t0;
		
		this.l = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		this.ux = (this.x2 - this.x1) / this.l;
		this.uy = (this.y2 - this.y1) / this.l;
	}

	public double getX(double t) {
		if (t <= t0) {
			return this.x1;
		} else if (t >= l / v + t0) {
			return this.x2;
		} else {
			this.dt = t - this.t0;
			this.x = this.x1 + this.v * this.ux * this.dt;
			return this.x;
		}
	}
	
	public double getY(double t) {
		if (t <= t0) {
			return this.y1;
		} else if (t >= l / v + t0) {
			return this.y2;
		} else {
			this.dt = t - this.t0;
			this.y = this.y1 + this.v * this.uy * this.dt;
			return this.y;
		}
	}
	

}
