package datapoints;

import mathfunctions.Regression;

public class DataPointOverview implements Regression{
	
	// initialize fields
	DataPoint[] datapoints;
	double[] x;
	double[] y;
	
	// constructor
	public DataPointOverview(DataPoint[] datapoints, double[] x, double[] y) {
		super();
		this.datapoints = datapoints;
		this.x = x;
		this.y = y;
	}
	
	// getters
	public double[] getX() {
		return x;
	}

	public double[] getY() {
		return y;
	}
	
	public DataPoint[] getDatapoints() {
		return datapoints;
	}
	
	// calculate sum of a variable, log = true = it is log
	@Override
	public double sumVar(double[] var, boolean log) {
		
		// initialize
		double var_sum = 0;

		// computation
		for(int i = 0; i < var.length; i++) {
			if(log) {
				var_sum += Math.log(var[i]);
			} else {
				var_sum += var[i];
			}
		}
		
		return var_sum;
	}
	
	// this function calculates the mean of a variable
	@Override
	public double arithmeticMean(double[] var) {
		double sumVar = sumVar(var, false);
		
		// initialize Variable
		double mean = 0;
	
		// compute mean
		mean = sumVar / var.length;
		
		return mean;
	}
	
	// to calculate x * y, log = true = it is log
	@Override
	public double x_times_y(double[] x, double[] y, boolean log) {
		
		// initialize
		double x2 = 0;
		double[] y_log = new double[y.length];
		
		// if log
		if(log) {
			for(int i = 0; i < y.length; i++) {
				y_log[i] = Math.log(y[i]);
			} 
		} else {
			for(int i = 0; i < y.length; i++) {
				y_log[i] = y[i];
			} 
		}
		
		for(int i = 0; i < x.length; i++) {
			x2 += x[i] * y_log[i];
		}
		
		return x2;
	}
	
	// this calculates residuals
	@Override
	public double residuals(double[] y, double[] x, double t, double m, boolean log) {
		double sumError = 0;
		double[] y_hat = y_hat_calc(x, t, m, log);
		
		for(int i = 0; i < y.length; i++) {
			sumError += (y[i] - y_hat[i]) * (y[i] - y_hat[i]);
		}
		
		return sumError;
	}
	
	// this calculates y_hat
	@Override
	public double[] y_hat_calc(double[] x, double t, double m, boolean log) {
		
		// initialize
		double[] y_hat = new double[x.length];
		
		// solve equation depending if log or not (true = it is log)
		for(int i = 0; i < x.length; i++) {
			if(log) {
				y_hat[i] = t * Math.exp(m * x[i]);
			} else {
				y_hat[i] = t + x[i] * m;
			}
		}
		
		return y_hat;
	}
	
}
