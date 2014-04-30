import java.lang.Math;

public class BlusterCritter extends Critter{

    private static final double LIGHTENING_FACTOR = 0.05;

    public void processActors(ArrayList<Actor> actors){
	super.processActors(actors);
	int neighbors=0;
	for(Actor a : actors){
	    int r=a.getLocation().getRow();
	    int c=a.getLocation().getCol();
	    if(a instanceof Critter && 
	       Math.abs(getLocation.getRow-r)<3 &&
	       Math.abs(getLocation.getCol-c)<3){
		Color c = getColor();
		int red = (int) (c.getRed() * (1 + LIGHTENING_FACTOR));
		int green = (int) (c.getGreen() * (1 + LIGHTENING_FACTOR));
		int blue = (int) (c.getBlue() * (1 + LIGHTENING_FACTOR));
		setColor(new Color(red, green, blue));	 
	    }
	}
    }

}
