package riceBugs;

import java.util.ArrayList;

public class PaddyField {
	public int m;
	public int n;
	Plant[][] field;
	ArrayList<RiceBug> bugs = new ArrayList<RiceBug>();
	public int infectedPlants;

public PaddyField(int m, int n){
	this.m = m;
	this.n = n;
	field = new Plant[m][n];
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			field[i][j] = new Plant(i,j);
		}		
	}	
}

public void addBug(RiceBug r){
	bugs.add(r);
}

public void spawn(RiceBug r){
	
	for(int i=0; i<field[r.xpos][r.ypos].bugsOnPlant.size(); i++){
		RiceBug b = field[r.xpos][r.ypos].bugsOnPlant.get(i);
		r.opponents.add(b);
	}
	field[r.xpos][r.ypos].addBug(r);
	fight(r);
	
}

public void move(int simNum){
	RiceBug r;
	for(int i=0; i<bugs.size(); i++){
		r = bugs.get(i);
		
		if(simNum == r.startTime){
			spawn(r);
		}
		else{
			if(simNum > r.startTime){
				field[r.xpos][r.ypos].removeBug(r);
				
				RiceBug temp;
		
				if(field[r.xpos][r.ypos].bugsOnPlant != null){
					for(int j=0; j<field[r.xpos][r.ypos].bugsOnPlant.size(); j++){
						temp = field[r.xpos][r.ypos].bugsOnPlant.get(j);
						temp.opponents.remove(r);
					}
				}

				r.xpos += r.xposMoveValue;
				r.ypos += r.yposMoveValue;
	
				if((r.xpos+1) > m || (r.ypos+1) > n || (r.xpos) < 0 || (r.ypos) < 0){
					die(r);
				}
				else{
					if(field[r.xpos][r.ypos].bugsOnPlant != null){
						for(int j=0; j<field[r.xpos][r.ypos].bugsOnPlant.size(); j++){
							r.opponents.add(field[r.xpos][r.ypos].bugsOnPlant.get(j));
						}
						field[r.xpos][r.ypos].addBug(r);
						fight(r);
					}
				}
			}
		}
	}
	
}

public void tryInfect(RiceBug r, Plant p){
	if(p.bugsOnPlant.size()>1 && p.infected == false){
		for(int i=0; i<p.bugsOnPlant.size(); i++){
			RiceBug b = p.bugsOnPlant.get(i);
			b.strength++;
			p.infected = true;
			infectedPlants++;
		}
	}
	else{
		if(p.infected == false){
			infect(r,p);
		}
	}
}

public void infect(RiceBug r, Plant p){
	p.infected = true;
	r.strength++;
	infectedPlants++;
}

public void fight(RiceBug r){
	if(r.opponents != null){
		RiceBug temp;
		
		for(int i=0; i<r.opponents.size(); i++){
			temp = r.opponents.get(i);
			if(r.strength > temp.strength){
				die(temp);
				field[temp.xpos][temp.ypos].removeBug(temp);
			}
			if(r.strength < temp.strength){
				die(r);
				field[r.xpos][r.ypos].removeBug(r);
				return;
			}
		}
		tryInfect(r, field[r.xpos][r.ypos]);
	}
}

public void die(RiceBug r){
	bugs.remove(r);
	RiceBug temp;
	
	for(int i=0; i<bugs.size(); i++){
		temp = bugs.get(i);
		temp.opponents.remove(r);
	}
}

}