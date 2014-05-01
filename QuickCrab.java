import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter{

    public ArrayList<Location> getMoveLocations(){
    
        ArrayList<Location> result = new ArrayList<Location>();
        
        ArrayList<Integer> dirs = new ArrayList<Integer>();
        dirs.add( this.getDirection() + 90 );
        dirs.add( this.getDirection() - 90 );
        
        for (Integer d : dirs)
            Location spot = this.getLocation().getAdjacentLocation(d);
            spot = spot.getAdjacentLocation(d);
            
            if ( ( this.getGrid().isValid(spot) )   &&
                 ( this.getGrid().get(spot) == null )){
                result.add(spot);
            }
        return result;
    }

    public Location selectMoveLocation(ArrayList<Location> locs){
        if ( locs.size() < 2 )
            return this.getLocation();
        else
            return locs.get( (int) ( Math.random() * locs.size() ) );
    }
}  

