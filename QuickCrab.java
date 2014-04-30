import info.gridworld.actor.Actor; 
import info.gridworld.actor.Critter; 
import info.gridworld.grid.Grid; 
import info.gridworld.grid.Location; 
 
import java.awt.Color; 
import java.util.ArrayList; 
 
public class QuickCrab extends CrabCritter { 
 
    public QuickCrab() { 
        setColor(Color.YELLOW); 
     } 

     public ArrayList<Location> getMoveLocations(){ 
        ArrayList<Location> loc = new ArrayList<Location>(); 
        Grid g = getGrid();  
        addIfGoodTwoAwayMove(loc,getDirection() + Location.LEFT); 
        addIfGoodTwoAwayMove(loc,getDirection() + Location.RIGHT);          
        if (loc.size() == 0) 
            return super.getMoveLocations();         
        return loc; 
    } 

     private void addIfGoodTwoAwayMove(ArrayList<Location> loc,int dir) { 
        Grid g = getGrid(); 
        Location loc = getLocation(); 
        Location temp = loc.getAdjacentLocation(dir); 
        if(g.isValid(temp) && g.get(temp) == null)  
            Location loc1 = temp.getAdjacentLocation(dir); 
            if(g.isValid(loc1) && g.get(loc1)== null) 
                loc.add(loc1);         
    } 
} 
