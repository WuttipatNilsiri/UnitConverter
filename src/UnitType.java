
public enum UnitType {
	
	length(Length.values()),
	area(Area.values()),
	mass(Mass.values());
	
	Unit[] a;
	UnitType(Unit[] a){
		this.a = a;
	}
	/**
	 * get all units name
	 * @return
	 */
	public Unit[] getUnits(){
		return a;
		
	}
	
	
}
