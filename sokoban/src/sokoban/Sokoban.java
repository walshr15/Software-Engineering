package sokoban;

import java.util.*;

public class Sokoban {
	
	static int X, Y, destX, destY, startX, startY;
    static int[][] arr;
    public int shortest, theCount;
    public final char North = 'N';
    public final char South = 'S';
    public final char East = 'E';
    public final char West = 'W';

	public void read(){
        Scanner sin = new Scanner(System.in);
        X = sin.nextInt();
        Y = sin.nextInt();
        arr = new int[X][Y];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                arr[i][j] = -1;
            }
        }
        sin.nextLine();
        for (int i = 0; i < X; i++) {
            String tmp = sin.nextLine();
            for (int j = 0; j < Y; j++) {                
                char ch = tmp.charAt(j);
                switch (ch) {
                    case '#':
                        arr[i][j] = -1;
                        break;
                    case 'B':
                        arr[i][j] = 1;
                        break;
                    case 'D':
                        destX = i;
                        destY = j;
                        arr[i][j]=2;
                        break;
                    default:
                        arr[i][j] = 0;
                }
            }
        }
        
        int[][] visit = new int[X][Y];
        resetVisited(visit);
        for(int i=0; i<arr.length; i++){
        	for(int j=0; j<arr[i].length; j++){
        		if(arr[i][j]==1){
        			startX = i;
        			startY = j;
        		}
        	}
        }
        theCount=0;
//      System.out.println(startX + " " + startY);
        move(visit, 'x', startX, startY, theCount);
    }
	
	public void move(int[][] visited, char prevDir, int xpos, int ypos, int count){
		if(arr[xpos][ypos]==2){
			System.out.println(count);
		}
		else{		
			
			if(prevDir == 'x'){
				resetVisited(visited);
				moveNorth(visited,prevDir, xpos, ypos, count);
				
				resetVisited(visited);
				moveSouth(visited, prevDir, xpos, ypos, count);
				
				resetVisited(visited);
				moveEast(visited, prevDir, xpos, ypos, count);
				
				resetVisited(visited);
				moveWest(visited, prevDir, xpos, ypos, count);
			}
			
			if(prevDir == North){
				int duplicate[][] = visited;
				moveNorth(visited, prevDir, xpos, ypos, count);
				
				int duplicate1[][] = duplicate;
				moveEast(duplicate, prevDir, xpos, ypos, count);
				
				moveWest(duplicate1, prevDir, xpos, ypos, count);
			}
			
			if(prevDir == South){
				int duplicate[][] = visited;
				moveSouth(visited, prevDir, xpos, ypos, count);
				
				int duplicate1[][] = duplicate;
				moveEast(duplicate, prevDir, xpos, ypos, count);
				
				moveWest(duplicate1, prevDir, xpos, ypos, count);
			}
			
			if(prevDir == East){
				int duplicate[][] = visited;
				moveNorth(visited, prevDir, xpos, ypos, count);
				
				int duplicate1[][] = duplicate;
				moveSouth(duplicate, prevDir, xpos, ypos, count);
				
				
				moveEast(duplicate1, prevDir, xpos, ypos, count);
			}
			
			if(prevDir == West){
				moveNorth(visited, prevDir, xpos, ypos, count);
				moveSouth(visited, prevDir, xpos, ypos, count);
				moveWest(visited, prevDir, xpos, ypos, count);
			}
			
		}
			
	}

	public void moveNorth(int[][] vis, char prevDir, int xpos, int ypos, int count){
		if(ypos < Y-1 && ypos > 0){
			if(arr[xpos][ypos-1]!=-1 && arr[xpos][ypos+1]!=-1 && arr[xpos][ypos+1]!=1 && vis[xpos][ypos+1]!= 1){
				ypos++;
				count++;
				vis[xpos][ypos] = 1;
				move(vis, North, xpos, ypos, count);
			}
		}
	}
	
	public void moveSouth(int[][] vis, char prevDir, int xpos, int ypos, int count){
		if(ypos > 0 && ypos < Y-1){
			if(arr[xpos][ypos+1]!=-1 && arr[xpos][ypos-1]!=-1 && arr[xpos][ypos-1]!=1 && vis[xpos][ypos-1]!=1){
				ypos--;
				count++;
				vis[xpos][ypos] = 1;
				move(vis, South, xpos, ypos, count);
			}
		}
	}
	
	public void moveEast(int[][] vis, char prevDir, int xpos, int ypos, int count){
		if(xpos < X-1 && xpos > 0){
			if(arr[xpos-1][ypos]!=-1 && arr[xpos+1][ypos]!=-1 && arr[xpos+1][ypos]!=1 && vis[xpos+1][ypos]!=1){
				xpos++;
				count++;
				vis[xpos][ypos] = 1;
				move(vis, East, xpos, ypos, count);
			}
		}
	}

	public void moveWest(int[][] vis, char prevDir, int xpos, int ypos, int count){
		if(xpos > 0 && xpos < X-1){
			if(arr[xpos+1][ypos]!=-1 && arr[xpos-1][ypos]!=-1 && arr[xpos-1][ypos]!=1 && vis[xpos-1][ypos]!=1){
				xpos--;
				count++;
				vis[xpos][ypos] = 1;
				move(vis, West, xpos, ypos, count);
			}
		}
	}

	public void resetVisited(int[][] vis){
		for(int i=0; i<vis.length; i++){
			for(int j=0; j<vis[i].length; j++){
				vis[i][j]=0;
			}
		}
	}
}

