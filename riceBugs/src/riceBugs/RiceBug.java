package riceBugs;

import java.util.ArrayList;

public class RiceBug {
	public int xpos;
	public int ypos;
	public int strength;
	public char direction;
	public int xposMoveValue;
	public int yposMoveValue;
	public int index;
	public int startTime;
	public ArrayList<RiceBug> opponents = new ArrayList<RiceBug>();

public RiceBug(int xpos, int ypos, int startTime, char direction, int index){
	this.xpos = xpos;
	this.ypos = ypos;
	this.direction = direction;
	this.startTime = startTime;
	this.index = index;
	
	if(direction == 'a' || direction == 'A'){
		xposMoveValue = -1;
		yposMoveValue = -1;
	}
	if(direction == 'b' || direction == 'B'){
		xposMoveValue = 0;
		yposMoveValue = -1;
	}
	if(direction == 'c' || direction == 'C'){
		xposMoveValue = 1;
		yposMoveValue = -1;
	}
	if(direction == 'd' || direction == 'D'){
		xposMoveValue = -1;
		yposMoveValue = 0;
	}
	if(direction == 'e' || direction == 'E'){
		xposMoveValue = 1;
		yposMoveValue = 0;
	}
	if(direction == 'f' || direction == 'F'){
		xposMoveValue = -1;
		yposMoveValue = 1;
	}
	if(direction == 'g' || direction == 'G'){
		xposMoveValue = 0;
		yposMoveValue = 1;
	}
	if(direction == 'h' || direction == 'H'){
		xposMoveValue = 1;
		yposMoveValue = 1;
	}
}
 
}