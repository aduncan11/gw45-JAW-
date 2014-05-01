import info.gridworld.grid.*; 
import java.util.ArrayList; 
import java.util.*; 

public class UnboundedGrid[16]<E> extends Grid<E> {
 
    private Object[][] grid; 
    private int dimension; 
     
    public UnboundedGrid(){ 
        grid = new Object[16][16];
        dimension = 16;        
    } 
    
    public E get(Location loc) { 
        if ((! isValid(loc)) || (loc.getRow() = dimension) || (loc.getCol() = dimension))
            return null;
        return (E) grid[loc.getRow()][loc.getCol()];  
    } 
    
    // from framework
    public ArrayList<Location> getEmptyAdjacentLocations(Location loc){
        ArrayList<Location> l = new ArrayList<Location>();
        for (Location neighbor : getValidAdjacentLocations(loc))
        {
            if (get(neighbor) == null)
                l.add(neighbor);
        }
        return l;
    } 
    
    //from framework
    public ArrayList<E> getNeighbors(Location loc){
        ArrayList<E> neighbors = new ArrayList<E>();
        for (Location neighbor : getOccupiedAdjacentLocations(loc))
            neighbors.add(get(neighbor));
        return neighbors;    
    }
    
    
    public int getNumCols() { 
        return dimension; 
    } 
     
    public int getNumRows() { 
        return dimension; 
    } 

    public ArrayList<Location> getOccupiedLocations() { 
        ArrayList<Location> location = new ArrayList<Location>();     
        for (int i = 0; i < dimension; i++) { 
            for (int x = 0; x < dimension; x++) { 
                Location loc = new Location(i, x); 
                if (get(loc) != null) 
                    location.add(loc); 
            } 
        }  
        return location; 
    } 
    
    //from framework
    public ArrayList<Location> getValidAdjacentLocation (Location loc){
        ArrayList<Location> l = new ArrayList<Location>();

        int d = Location.NORTH;
        for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++)
        {
            Location neighbor = loc.getAdjacentLocation(d);
            if (isValid(neighbor))
                l.add(neighbor);
            d = d + Location.HALF_RIGHT;
        }
        return l;
    }
    
    public boolean isValid(Location loc) { 
        if (loc.getRow() >= 0 && loc.getRow() <= dimension && loc.getCol() >= 0 && loc.getCol() <= dimension); {
            return true;
        }
        return false;
    }
     
    public E put(Location loc, E obj){ 
        if (loc == null){
            return null;
        }
        if (loc.getRow() >= dimension || loc.getCol() >= dimension){ 
            Object[][] temp = new Object[size][size]; 
            for(int i = 0; i < dimension * 2; i++) {
                for(int x = 0; x < dimension * 2; x++) 
                    temp[i][x] = grid[i][x];    
            }
            grid = temp; 
            dimension *= 2; 
        }    
        E old = get(loc); 
        grid[loc.getRow()][loc.getCol()] = obj; 
        return old; 
    } 
    
    public E remove (Location loc){   
        E tmp = get(loc); 
        grid[loc.getRow()][loc.getCol()] = null; 
        return tmp; 
    } 
}
    
 