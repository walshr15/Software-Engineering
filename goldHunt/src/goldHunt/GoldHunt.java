package goldHunt;

import java.util.ArrayList;
import java.util.Scanner;

public class GoldHunt {
	
	public boolean won = false;
	public ArrayList<Hunter> hunters = new ArrayList<Hunter>();
	static int X,Y;
	public char[][] arr;
	public int[][] xposArr;
	public int[][] yposArr;
	
	public void read(){
        Scanner sin = new Scanner(System.in);
        Y = sin.nextInt();
        X = sin.nextInt();
		
        arr = new char[Y][X];
        for (int i = 1; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                arr[i][j] = 'X';
            }
        }
               
        xposArr = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                xposArr[i][j] = 0;
            }
        }
        
        yposArr = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                yposArr[i][j] = 0;
            }
        }
        
        sin.nextLine();
        
        for(int i=0; i<Y; i++){
        	for (int j = 0; j < X; j++) {       
        		String tmp = sin.next();
        		char ch = tmp.charAt(0);
        			switch (ch) {
        			case 'T':
        				arr[i][j] = 'T';
        				break;
        			case 'G':
        				arr[i][j] = 'G';
        				break;
        			case 'D':
        				arr[i][j]='D';
        				int temp1 = sin.nextInt();
        				yposArr[i][j] = temp1;
        				temp1 = sin.nextInt();
        				xposArr[i][j] =temp1;                       
        				break;
        			case ' ':
        				break;
        			default:
        				
        			}
        	}
        }
        
//        for(int i=0; i<Y; i++){
//        	for(int j=0; j<X; j++){
//        		char c=arr[i][j];
//        		System.out.println(c + "("+i+","+j+")");
//        		System.out.println(yposArr[i][j] + "," + xposArr[i][j]);
//        	}
//        }
        
        
        int hunterAmount = sin.nextInt();
        for(int i=0; i<hunterAmount; i++){
        	int id = sin.nextInt();
        	int ypos = sin.nextInt();
        	int xpos = sin.nextInt();
        	Hunter h = new Hunter(id, ypos, xpos);
        	hunters.add(h);
        }
        sin.close();
	}


        

        
        
    public void sim(){
    	while(won!=true){
    		for(int i=0; i<hunters.size(); i++){
    			if(won!=true){
    				tryMove(hunters.get(i));
    			}
    		}
    	}
    }
        
	public void move(Hunter h){
		if(arr[h.ypos][h.xpos]=='D'){
			h.displacementX = xposArr[h.ypos][h.xpos];
			h.displacementY = yposArr[h.ypos][h.xpos];
			
			if(h.displacementX > X){
				h.displacementX = h.displacementX % X;
				h.xpos += h.displacementX;
			}
			else{
				if(h.displacementX < (X*-1)){
					h.displacementX = h.displacementX % X;
					h.xpos += h.displacementX;
				}
				else{
					if(h.xpos + h.displacementX < X && h.xpos + h.displacementX >= 0){
						h.xpos += h.displacementX;
					}
					else{
						if(h.xpos + h.displacementX >= X){
							h.xpos = ((h.xpos + h.displacementX) - X);
						}
						else{
							if(h.xpos + h.displacementX < 0){
								h.xpos = ((X)+(h.xpos + h.displacementX));
							}
						}
					}
				}
			}
			if(h.displacementY > Y){
				h.displacementY = h.displacementY % Y;
				h.ypos += h.displacementY;
			}
			else{
				if(h.displacementY < (Y*-1)){
					h.displacementY = h.displacementY % Y;
					h.ypos += h.displacementY;
				}
				else{
					if(h.ypos + h.displacementY < Y && h.ypos + h.displacementY >= 0){
						h.ypos += h.displacementY;
					}
					else{
						if(h.ypos + h.displacementY >= Y){
							h.ypos = ((h.ypos + h.displacementY) - Y);
						}
						else{
							if(h.ypos + h.displacementY < 0){
								h.ypos = ((Y) + (h.ypos + h.displacementY));
							}
						}
					}
				}
			}
		}
		else{
			if(arr[h.ypos][h.xpos] == 'G'){
				System.out.println(h.id);
				won = true;
			}
			else{
				if(arr[h.ypos][h.xpos] == 'T'){
					h.trapped = true;
				}
			}
		}
	}
	
	public void tryMove(Hunter h){
		if(h.trapped == false){
			move(h);
		}
	}
}
