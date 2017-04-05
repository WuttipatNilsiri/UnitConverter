
public enum Mass implements Unit{
	litre(1),
	Cubic_meter(0.001),
	Milliliters(1000),
	
	pound(2.20),
	Gallon(0.264172052);
	
	private double value;
	Mass(double value){
		this.value = value;
	}
	
	/**
	 * get value from enum
	 * @return value
	 */
	public double getValue(){
		return value;
	}
	/**
	 * to String 
	 */
	public String toString(){
		return name();
	}
	
	
}
