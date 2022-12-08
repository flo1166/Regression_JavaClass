package mathfunctions;

public interface Regression {
	
	// to get sum of variable
	double sumVar(double[] var, boolean log);
	double arithmeticMean(double[] var);
	double x_times_y(double[] x, double[] y, boolean log);
	double residuals(double[] y, double[] x, double t, double m, boolean log);
	double[] y_hat_calc(double[] x, double t, double m, boolean log);
}
