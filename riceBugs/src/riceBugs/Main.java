package riceBugs;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
//		System.out.println("Enter your field size (in format X Y) buddy:" );
		Scanner reader = new Scanner(System.in);
		int m = reader.nextInt(); // get M x N and make field of M x N
		int n = reader.nextInt();
		
		PaddyField field = new PaddyField(m,n);
		ArrayList<RiceBug> bugs = new ArrayList<RiceBug>();
		
//		System.out.println("Enter simulation period:");
		Scanner reader1 = new Scanner(System.in);
		int simulationPeriod = reader1.nextInt();
		
//		System.out.println("Enter amount of bugs:" );
		Scanner reader2 = new Scanner(System.in);
		int bugAmount = reader2.nextInt();
		
		Scanner reader3 = new Scanner(System.in);
		for(int i=0; i<bugAmount; i++){
//			System.out.println("Enter bug info:");
			
			int ypos = reader3.nextInt();
			int xpos = reader3.nextInt();
			int startTime = reader3.nextInt();
			String direction1 = reader3.next();
			char direction = direction1.charAt(0);
			RiceBug r = new RiceBug(xpos, ypos, startTime, direction, i);
			bugs.add(r);
		}
		
		for(int j=0; j<bugs.size(); j++){
			RiceBug r = bugs.get(j);
			field.addBug(r);
		}
		for(int sim=1; sim<=simulationPeriod; sim++){
			field.move(sim);

			int survivors = 0;
			int uninfected = 0;
			for(int k=0; k<m; k++){
				for(int l=0; l<n; l++){
					if(field.field[k][l].bugsOnPlant != null){
						survivors += field.field[k][l].bugsOnPlant.size();
					}
				}
			}
			
//			for(int k=0; k<m; k++){
//				for(int l=0; l<n; l++){
//					if(field.field[k][l].bugsOnPlant.size() > 0){
//						int zero=0;
//						RiceBug b = field.field[k][l].bugsOnPlant.get(zero);
//						System.out.print("| " + b.index+10 + " | "  + field.field[k][l].xpos + "," + field.field[k][l].ypos);
//					}
//					else{
//						if(field.field[k][l].infected == true){
//							System.out.print("| 1 | " + field.field[k][l].xpos + "," + field.field[k][l].ypos);
//						}
//						else{
//							if(field.field[k][l].infected == false){
//								System.out.print("| 0 | " +  + field.field[k][l].xpos + "," + field.field[k][l].ypos);
//							}
//						}
//					}
//					System.out.println(" ");
//				}
//			}
			
			uninfected = (m*n)-field.infectedPlants;
			System.out.println("Simulation " +  sim + ": Uninfected plants = " + uninfected + ", Survivors = " + survivors);
		}
		reader3.close();
		reader2.close();
		reader1.close();
		reader.close();
	}
}


