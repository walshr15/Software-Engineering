package riceBugs;
import java.util.ArrayList;

public class Plant {
	public boolean infected;
	public int xpos;
	public int ypos;
	ArrayList<RiceBug> bugsOnPlant = new ArrayList<RiceBug>();

public Plant(int xpos, int ypos){
	this.infected = false;
	this.xpos = xpos;
	this.ypos = ypos;
}

public void addBug(RiceBug r){
	 bugsOnPlant.add(r);
}

public void removeBug(RiceBug r){
	bugsOnPlant.remove(r);
}

}