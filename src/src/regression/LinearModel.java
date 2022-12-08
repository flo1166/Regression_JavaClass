package regression;

import datapoints.DataPoint;
import datapoints.DataPointOverview;

public class LinearModel {
	
	// overall method to compute linear model
	public static void printLinear(DataPointOverview datapoints) {
		
		double m = m(datapoints);
		double t = t(datapoints);
		double residuals = datapoints.residuals(datapoints.getY(), datapoints.getX(), t, m, false);
		System.out.println("m = " + m + "   t = " + t + "   residuals = " + residuals);
	}
	
	// calculate m (Steigung)
	public static double m(DataPointOverview datapoints) {
		
		// initialize variables
		double sum_xy = 0;
		double sum_x2 = 0;
		double m = 0;
		
		// compute mean
		double x_mean = datapoints.arithmeticMean(datapoints.getX());
		double y_mean = datapoints.arithmeticMean(datapoints.getY());
		
		// calculate m
		DataPoint[] datapointer = datapoints.getDatapoints();
		for(int i = 0; i < datapointer.length; i++) {
			sum_xy += (datapointer[i].getWeek() - x_mean) * (datapointer[i].getPrice() - y_mean);
			sum_x2 += (datapointer[i].getWeek() - x_mean) * (datapointer[i].getWeek() - x_mean);	
		}
		
		m = sum_xy / sum_x2;
		
		return m;
	}
	
	// this function calculates the t
	public static double t(DataPointOverview datapoints) {
	
		// compute mean
		double x_mean = datapoints.arithmeticMean(datapoints.getX());
		double y_mean = datapoints.arithmeticMean(datapoints.getY());
		
		// compute t
		double t = y_mean - m(datapoints) * x_mean;
		
		return t;
	}
}
