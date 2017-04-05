import java.util.*;

/**
 * Unit Converter
 * @author ARZ
 *
 */
public class UnitConverter {
	static double ans;
	private static UnitConverter unitConverter = null;
	List<String> unitnamelist = new ArrayList<String>();
	
	public UnitConverter(){}
	
	public static UnitConverter getUnitConverter(){
		if (unitConverter == null){
			unitConverter = new UnitConverter();
		}
		return unitConverter;
	}
	/**
	 * unit convert pantern  
	 * @param input
	 * @param unit1
	 * @param unit2
	 */
	public static void convert(double input,Unit unit1,Unit unit2){
		if(getType(unit1).equals(getType(unit2))){
			ans = input / unit1.getValue() * unit2.getValue(); // convert to meter first then to that wanted value
		}else
			System.out.println("ERRR");
	}
	
	/**
	 * get converted number 
	 * @return ans (converted number)
	 */
	public static double getAns(){
		return ans;
	}
	
	/**
	 * get unit class name
	 * @param unit
	 * @return unit class name
	 */
	public static String getType(Unit unit){
		return unit.getClass().getName();
	}
	
	public static Unit[] getUnits(UnitType a){
		return a.getUnits();
		
	}
	
	public static void main(String[]a){
		for (Unit x : getUnits(UnitType.length))
		System.out.println(x.toString());
	}
	
	
	
}
