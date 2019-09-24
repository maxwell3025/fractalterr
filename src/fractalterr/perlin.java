 package fractalterr;

public class perlin {
	public static double perl(double x, double y, double[][] angles) {
		double diffx = x - ((int) x);
		double diffy = y - ((int) y);
		point a = new point(Math.sin(angles[(int) x][(int) y]), Math.cos(angles[(int) x][(int) y]));
		point b = new point(Math.sin(angles[(int) x + 1][(int) y]), Math.cos(angles[(int) x + 1][(int) y]));
		point c = new point(Math.sin(angles[(int) x][(int) y + 1]), Math.cos(angles[(int) x][(int) y + 1]));
		point d = new point(Math.sin(angles[(int) x + 1][(int) y + 1]), Math.cos(angles[(int) x + 1][(int) y + 1]));
		double q = dotp(a.x, a.y, diffx, diffy);
		double w = dotp(b.x, b.y, diffx-1 , diffy);
		double e = dotp(c.x, c.y, diffx, diffy- 1 );
		double r = dotp(d.x, d.y, diffx- 1 , diffy - 1);

		return (inter(inter(q,w , diffx),inter(e,r , diffx) , diffy));

	}

	public static double inter(double p1, double p2, double inter) {
		return p1 * (1 - thingy(inter)) + p2 * thingy(inter);
	}

	public static double dotp(double x1, double y1, double x2, double y2) {
		return x1 * x2 + y1 * y2;
	}
	public static double thingy(double x){
		return 1-(Math.cos(x*Math.PI)+1)/2;
	}

	public static class point {
		double x;
		double y;

		public point(double f, double r) {
			x = f;
			y = r;
		}
	}
}
