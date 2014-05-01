import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import java.util.ArrayList;
public class GhostCritter extends Critter{
      public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0){
	    return;
	}
	else{
	    for (Actor a : actors){
		if (!((a instanceof Rock) || (a instanceof Flower) || (a instanceof GhostCritter))){
		    System.out.println(a.getDirection());
		    System.out.println(this.getLocation().getDirectionToward(a.getLocation()));
		    a.setDirection(this.getLocation().getDirectionToward(a.getLocation()));
		    System.out.println(a.getDirection());
		    flee(a.getDirection(), a);
		}
	    }
	    
	}
    }
	public void flee( int dir, Actor a){
	    int i = 0;
	    while (i < 3){
		Location current = a.getLocation();
		Location loc =  a.getLocation().getAdjacentLocation(dir);
		if (a.getGrid().isValid(loc)){
		    a.moveTo(loc);
		}
		else{
		    a.removeSelfFromGrid();
		    GhostCritter c = new GhostCritter();
		    c.putSelfInGrid(getGrid(),current);
		    return;
		}
		i++;
	    }
	}
}
