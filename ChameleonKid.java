import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.util.*;
public class ChameleonKid extends ChameleonCritter{
    public ArrayList<Actor> getActors(){
	ArrayList<Actor> a = new ArrayList<Actor>();
	if (getGrid().isValid(getLocation().getAdjacentLocation(getDirection())))
	    {
	    Actor f = getGrid().get(getLocation().getAdjacentLocation(getDirection()));
	    if (f != null)
	    a.add(f);
	    }
	    if (getGrid().isValid(getLocation().getAdjacentLocation(getDirection()-180))){   
	Actor b = getGrid().get(getLocation().getAdjacentLocation(getDirection()-180));
	if (b != null)
	    a.add(b);
	    }


	return a;
    }
}
		
