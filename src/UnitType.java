
public enum UnitType {
	
	length(Length.values()),
	area(Area.values()),
	mass(Mass.values());
	
	Unit[] a;
	UnitType(Unit[] a){
		this.a = a;
	}
	public Unit[] getUnits(){
		return a;
		
	}
	
	
}
