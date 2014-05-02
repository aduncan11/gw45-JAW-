public class OccupantInCol{
    private Object occupant; 
    private int col;
    
    public void ObjectInCol(Object obj, int c){
	col=c;
	occupant=obj;
    }
    
    public Object getOccupant(){
	return occupant;
    }
    public int getCols(){
	return col;
    }
}
