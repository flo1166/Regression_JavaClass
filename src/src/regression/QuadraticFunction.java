package regression;

import datapoints.DataPointOverview;

public class QuadraticFunction {
	
	// overall method to compute quadratic model
	public static void printQuadratic(DataPointOverview datapoints) {
		
		double a = a(datapoints);
		double lambda = lambda(datapoints);
		double residuals = datapoints.residuals(datapoints.getY(), datapoints.getX(), a, lambda, true);
		System.out.println("a = " + a + "   lambda = " + lambda + "   residuals = " + residuals);
	}
	
	// calculate m (Steigung) -> lambda
	public static double lambda(DataPointOverview datapoints) {
		
		// initialize variables
		double x_sum = datapoints.sumVar(datapoints.getX(), false);
		double y_sum = datapoints.sumVar(datapoints.getY(), true);
		double x_times_y = datapoints.x_times_y(datapoints.getX(), datapoints.getY(), true);
		double x2 = datapoints.x_times_y(datapoints.getX(), datapoints.getX(), false);
		
		// calculate lambda
		double lambda = (datapoints.getDatapoints().length * x_times_y - y_sum * x_sum) / (datapoints.getDatapoints().length * x2 - x_sum * x_sum);
		
		return lambda;
	}
	
	// this function calculates the t -> a
	public static double a(DataPointOverview datapoints) {
		
		// initialize variables
		double x_sum = datapoints.sumVar(datapoints.getX(), false);
		double y_sum = datapoints.sumVar(datapoints.getY(), true);
				
		// compute lambda
		double lambda = lambda(datapoints);
		
		// compute a
		double a = Math.exp((y_sum / datapoints.getDatapoints().length) - lambda * (x_sum / datapoints.getDatapoints().length));
		
		return a;
	}
}
