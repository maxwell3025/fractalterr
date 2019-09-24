package fractalterr;

public class methods {

	public static double[][] ds(int power) {
		int numberthing = exp(2, power);
		double[][] map = new double[exp(2, power)][exp(2, power)];
		boolean[][] registered = new boolean[exp(2, power)][exp(2, power)];
		map[0][0] = 0;
		registered[0][0] = true;
		for (int i = 0; i <= power; i++) {
			numberthing = numberthing / 2;
			for (int x = 0; x < exp(2, i); x++) {
				for (int y = 0; y < exp(2, i); y++) {
					if(booleanat(x, y, registered)){
						registered=booleanwrite(x+numberthing, y+numberthing,  registered, true);
						map=numberwrite(1, 1,map, 0);
					}
				}
			}
			for (int x = 0; x < exp(2, i); x++) { 
				for (int y = 0; y < exp(2, i); y++) {
					
				}
			}

		}
		return map;
	}

	public static double exp(double numb, int power) {
		double x = 1;
		for (int y = 0; y < power; y++) {
			x = x * numb;
		}
		return x;
	}

	public static int exp(int numb, int power) {
		int x = 1;
		for (int y = 0; y < power; y++) {
			x = x * numb;
		}
		return x;
	}

	public static double average(double a, double b, double c, double d, double range) {
		return (a + b + c + d) / 4 + ((Math.random() - 0.5)*range* 16);
	}

	public static double numberat(int x, int y, double[][] map) {
		return map[Math.abs(x % map[0].length)][Math.abs(y % map[0].length)];
	}
	public static double[][] numberwrite(int x, int y, double[][] map, double input) {
		double[][] thing=map;
		thing[Math.abs(x % map[0].length)][Math.abs(y % map[0].length)]=input;
		return thing;
	}
	public static boolean booleanat(int x, int y, boolean[][] map) {
		return map[Math.abs(x % map[0].length)][Math.abs(y % map[0].length)];
	}
	public static boolean[][] booleanwrite(int x, int y, boolean[][] map, boolean input) {
		boolean[][] thing=map;
		thing[Math.abs(x % map[0].length)][Math.abs(y % map[0].length)]=input;
		return thing;
	}
	public class point{
		public int x;
		public int y;
		public point(int a, int b){
			
		}
	}
}
