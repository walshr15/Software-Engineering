package goldHunt;

public class Hunter {

	public int id;
	public int xpos;
	public int ypos;
	public int displacementX;
	public int displacementY;
	public boolean trapped;
	
	public Hunter(int id, int ypos, int xpos){
		this.id = id;
		this.xpos = xpos;
		this.ypos = ypos;
		displacementX=0;
		displacementY=0;
	}
}
