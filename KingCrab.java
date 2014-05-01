import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.ArrayList;

public class KingCrab extends CrabCritter{

    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors){
            int dir = this.getLocation().getDirectionToward( a.getLocation() );
            Location next = a.getLocation().getAdjacentLocation(dir);
            
            if ( this.getGrid().isValid(next) )
                a.moveTo(next);
            else
                a.removeSelfFromGrid();
        }
    }
}

