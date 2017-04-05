/**
 * enum Length value
 * @author ARZ
 *
 */
public enum Length implements Unit{
	
	//ENG UNIT
	FOOT(3.2808399),
	MILE(0.000621371192),
	//SI UNIT
	METER(1),
	CENTIMETER(100),
	MICROMETER(1000000),
	//TH UNIT
	WA(0.5),
	;
	
	/**
	 * set value to enum 
	 */
	private double valuepermeter;
	Length(double value){
		this.valuepermeter = value;
	}
	
	/**
	 * get value from enum
	 * @return value
	 */
	public double getValue(){
		return valuepermeter;
	}
	/**
	 * to String 
	 */
	public String toString(){
		return name();
	}
	

	
	public static void main(String[] a){
		for (Unit x : values())
			System.out.println(x.toString());
	}

	
	
	
}
