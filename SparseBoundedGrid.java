class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private LinkedList<OccupantInCol>[] occupantArray; // the LL storing the grid elements
    
    public SparseBoundedGrid(int r, int c)
	occupantArray=new LinkedList<OccupantInCol>[r];
  {
      
  }
  public int getNumRows()
  {
      return occupantArray.length;
  }
  public int getNumCols()
  {
      
      return occupantArray[0].size() ;
  }
  public boolean isValid(Location loc)
  {
      return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	  
	  && 0 <= loc.getCol() && loc.getCol() < getNumCols();
  }
  
  
  public ArrayList<Location> getOccupiedLocations()
  {
      ArrayList<Location> theLocations = new ArrayList<Location>();
      // Look at all grid locations.
      for (int r = 0; r < getNumRows(); r++) {
	  for (int c = 0; c < getNumCols(); c++)
	  {
	      // If there's an object at this location, put it in the array. 
	      Location loc = new Location(r, c);
	      if (get(loc) != null)
		  theLocations.add(loc);
	  }
      }
      return theLocations;
  }
  
  
  
  public OccupantInCol get(Location loc)
  {
      if (!isValid(loc))
	  throw new IllegalArgumentException("Location " + loc + " is not valid");
      return (E) occupantArray[loc.getRow()].get(loc.getCall); // unavoidable warning
  }
  
  public OccupantInCol put(Location loc, OccupantInCol obj)
  {
      if (!isValid(loc))
	  throw new IllegalArgumentException("Location " + loc+ " is not valid");
      if (obj == null)
	  throw new NullPointerException("obj == null");
      // Add the object to the grid.
      E oldOccupant = get(loc); 
      occupantArray[loc.getRow()].add(obj, loc.getCol()); 
      remove(oldOccupant);
      return oldOccupant;
  }
  
  public E remove(Location loc)
  {
      if (!isValid(loc))
	  throw new IllegalArgumentException("Location " + loc + " is not valid");
      // Remove the object from the grid.
      ObjectInCol r = get(loc);
      occupantArray[loc.getRow()].add(null, loc.getCol());
      return r;
  } 
}

public class ObjectInCol{
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
	return c;
    }
}
