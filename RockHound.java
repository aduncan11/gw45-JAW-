public class RockHound extends Critter{

    public void processActors(ArrayList<Actor> actors){
	super.processActors(actors);
	for(Actors a : actors){
	    if (a instanceof Rock){
		a.removeSelfFromGrid();
	    }
	}
    }
    
}
