package info.gridworld.grid;

import java.util.*;

public class SparseBoundedGrid{
    private LinkedList<OccupantInCol>[] occupantArray; // 
    
    public SparseBoundedGrid(int r, int c){
	occupantArray=new LinkedList[r];
    }
 
  public int getNumRows() {
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
      return occupantArray[loc.getRow()].get(loc.getCol()); // unavoidable warning
  }
  
  public OccupantInCol put(Location loc, OccupantInCol obj)
  {
      if (!isValid(loc))
	  throw new IllegalArgumentException("Location " + loc+ " is not valid");
      if (obj == null)
	  throw new NullPointerException("obj == null");
      // Add the object to the grid.
      OccupantInCol oldOccupant = get(loc); 
      occupantArray[loc.getRow()].remove(loc.getCol());
      occupantArray[loc.getRow()].add(loc.getCol(), obj); 
      return oldOccupant;
  }
  
  public OccupantInCol remove(Location loc)
  {
      if (!isValid(loc))
	  throw new IllegalArgumentException("Location " + loc + " is not valid");
      // Remove the object from the grid.
      OccupantInCol r = get(loc);
      occupantArray[loc.getRow()].add(loc.getCol(), null);
      return r;
  } 
}
