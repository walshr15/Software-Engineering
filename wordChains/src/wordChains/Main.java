package wordChains;

import java.util.*;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		
		System.out.println("Number of words: ");
		Scanner reader = new Scanner(System.in);
		int numWords = reader.nextInt();
		
		
		String[] words = new String[numWords];
		boolean impossible = false;
		
		Scanner reader2= new Scanner(System.in);
		for(int i = 0; i < numWords; i ++){
			System.out.println("Word number " + (i+1));
			words[i] = reader2.next();
			if(words[i].length() < 3)
				impossible = true;
		}
		reader2.close();
		reader.close();
		
		ArrayList<Integer> used = new ArrayList<Integer>();
		used.add(0);
		String chain = words[0] + " " + remaining(used, words);
		
		if(impossible || chain.split(" ").length != numWords)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(chain.replace(" ", "\n"));
	}
	
	
	public static String remaining(ArrayList<Integer> usedWords, String[] words){
		if(usedWords.size() == words.length){
			return "";
		}
		String prev = words[usedWords.get(usedWords.size()-1)];
		
		for(int i=0; i<words.length; i++){
			boolean wordUsed = false;
			
			for(int j=0; j<usedWords.size(); j++){
				int temp = usedWords.get(j);
				
				if(temp == i){
					wordUsed = true;
				}
			}
			if(wordUsed == false){
				int smallest = prev.length();
				if(words[i].length() < smallest){
					smallest = words[i].length();
				}
				for(int k=3; k<=smallest; k++){
					if(prev.substring(prev.length() - k).equals(words[i].substring(0, k))){
						ArrayList<Integer> newArray = (ArrayList<Integer>) usedWords.clone();
						newArray.add(i);
						String total = words[i] + " " + remaining(newArray, words);
						if(total.split(" ").length == words.length - newArray.size() + 1)
							return total;
					}
				}
			}
		} return "";
	}
}
