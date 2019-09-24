package fractalterr;

public class threetotwo {

	public double[] threetwo(double x, double y, double z, double rot) {
		double[] coordinates = new double[2];
		coordinates[0]=(Math.sin(rot) * x + Math.sin(rot + Math.PI / 2) * y);
		return coordinates;
		// TODO Auto-generated constructor stub
	}

}
