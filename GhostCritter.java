/*****************************************************************
 * JAW
 * APCS pd # 8
 * HW## 35 GridWorld, Part 4
 * 2014-04-30
 *
 * class GhostCritter
 *
 * BEACUASE:
 * We implemented GhostCritter because I, Justin, was really excited about it - I read the Shining over the break.
 *
 * SPECIFICATIONS:
 * This subclass of Critter can scare away other actors (except Rocks, Flowers, and other GhostCritters) when it comes near them. If you are a neighbor of the GhostCritter, you change direction away from the GhostCritter and move forward two spaces. If they run off the edge of the grid, they remove themselves from the grid and may leave another GhostCritter behind. After processing the nearby actors, the GhostCritter moves the same way a Critter does.

 *
 * TEST CASES:
 *1. Surround the GhostCritter with neighbors in the center of the grid. They should turn around and flee two spaces. The GhostCritter should then move.
2. Surround the GhostCritter with neighbors in a corner or edge of the grid. They should turn around and try to flee. If they are next to the edge of the grid, they should "die" and have a chance of leaving a GhostCritter behind. The GC should then move.
3. Leave the GhostCritter in the center of the grid. It should move around normally. 
 *
 * ERRATA:
 *I added a test case - when a critter has to flee though a roack or a flower - and decided that the citter, in its fleeing frenzy, could bash through a roack and crush a flower. I also realized, after lots of runthroughs trying to figure out what was wrong, that sometimes the critter moves before the ghostCritter making the fleeing hard to observe in the gui.
 *****************************************************************/
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
