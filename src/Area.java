
public enum Area implements Unit{
	//SI UNIT
	SQRTMETER(1.0),
	SQRTCENTIMETER(10000.0),
	SQRTMICROMETER(1_000_000_000_000.0),
	//ENG UNIT
	ACRE(0.000247105381),
	ROOD(0.00098842153134),
	
	TARANG_WA(0.25);
	
	/**
	 * set value to enum 
	 */
	private double valueperSqrtmeter;
	Area(double value){
		this.valueperSqrtmeter = value;
	}
	
	/**
	 * get value from enum
	 * @return value
	 */
	public double getValue(){
		return valueperSqrtmeter;
	}
}
