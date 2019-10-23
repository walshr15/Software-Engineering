package wordChains;

import java.util.ArrayList;


public class WordChain {
	public Word[] chain;
	public ArrayList<String> words = new ArrayList<String>();
	public ArrayList<String> chained = new ArrayList<String>();
	public boolean canChain = true;
	

	public WordChain(int n, ArrayList<String> words){
		this.words = words;
//		chain = new Word[n];
//		for(int i=0; i<words.size(); i++){
//			chain[i] = words.get(i);
//		}
	}
	
	public void compare(String w){
		
		String compare;
		boolean match = false;
		words.remove(w);
		
		for(int i=0; i<words.size() || match == false; i++){
			compare = words.get(i);
			for(int /*j=0,*/ k=3; k<compare.length() || match == false; k++){
				String temp1 = "";
				String temp2 = "";
				for(int l=0; l<k; l++){
					temp1 += w.charAt((w.length()+(l-k)));
					temp2 += compare.charAt(l);
				}
				if(temp1.equals(temp2)){
					chained.add(temp1);
					chained.add(temp2);
					match = true;
					System.out.print(temp1 + " " + temp2);
				}
				else{
//					canChain = false;
				}
			}
		}
		if(match == false){
			canChain = false;
		}
		
		
//		String compare;
//		boolean match = false;
//		for(int i=0; i<0; i++){
//			compare = words.get(i).wholeWord;
//			while(match!=true){
//				for(int j=0; j<w.wholeWord.length(); j++){
//			}
//				
//			}
//		}
	}
	public void order(){
		
	}
}
