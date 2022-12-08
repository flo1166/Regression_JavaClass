package datapoints;

import regression.LinearModel;
import regression.QuadraticFunction;

public class Example {

	public static void main(String[] args) {
		
		DataPointOverview dataPointOverview = exampleDataPoints();
		LinearModel.printLinear(dataPointOverview);
		QuadraticFunction.printQuadratic(dataPointOverview);
	}
	
	public static DataPointOverview exampleDataPoints() {
		// week
		double[] weeks = new double[8];
		for (int i = 0; i < weeks.length; i++) {
			weeks[i] = i + 1;
		}		
		
		// price
		double[] prices = new double[8];
		prices[0] = 2.02;
		prices[1] = 1.95;
		prices[2] = 1.97;
		prices[3] = 1.91;
		prices[4] = 1.90;
		prices[5] = 1.87;
		prices[6] = 1.85;
		prices[7] = 1.85;
				
		// datapoints
		DataPoint[] datapoints = new DataPoint[8];
		for (int i = 0; i < prices.length; i++) {
			datapoints[i] = new DataPoint(weeks[i], prices[i]);
		}
		
		// datapointOverview
		DataPointOverview dataPointOverview = new DataPointOverview(datapoints, weeks, prices);
		
		return dataPointOverview;
	}
}
