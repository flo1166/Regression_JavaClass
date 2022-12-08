package datapoints;

public class DataPoint {
	final double week;
	final double price;
	
	// constructor
	public DataPoint(double week, double price) {
		this.week = week;
		this.price = price;
	}

	// getters
	public double getWeek() {
		return week;
	}

	public double getPrice() {
		return price;
	}
	
}
