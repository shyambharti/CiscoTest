package cisco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * This class to produce a count of all the different "words" in a text file.
 * 
 * @author Shyam Bharti
 *
 */
public class TrieThrWordCount {
	
    char ch;
    boolean eow;
    int count=0;
    
    Map<Character, TrieThrWordCount> child;
    

    public TrieThrWordCount(){
        child = new HashMap<>();
    }
    
    public TrieThrWordCount(char ch){
        child = new HashMap<>();
        this.ch=ch;
    }
    
	/**
	 * @param Array of words
	 * @param Instance of class(root)
	 */
	public void buildTrie(String[] words, TrieThrWordCount root) {
		for (String word : words) {
			TrieThrWordCount parent = root;
			for (char ch : word.toCharArray()) {
				TrieThrWordCount child = parent.child.get(ch);
				if (child == null) {
					child = new TrieThrWordCount(ch);
					parent.child.put(ch, child);
				}
				parent = child;
			}
			parent.count += 1;
			parent.eow = true;
		}
	}
    
    /**
     * This method is printing the count of words and  all the different "words" 
     * out : 
     * 12 apple
	 * 6 banana
	 * 1 ram
	 * 12 grap
	 * 6 lichi
	 * 12 mango
	 * 
     * @param Instance of class(root)
     * @param String(str)
     */
    public void printTrie(TrieThrWordCount root,String str){
    	if (root == null)
    		return;
        for (TrieThrWordCount child: root.child.values()){
            if (child.eow){
                System.out.println(child.count+ " " +str +child.ch );
                return;
            }  		
            printTrie(child,str+child.ch);
        }
    }
    public static void main(String[] args){
    	 String line;  
    	 try{
    	 //Opens a file in read mode  
         FileReader file = new FileReader("input");  
         BufferedReader br = new BufferedReader(file);  
         String words[]=null;
         TrieThrWordCount root = new TrieThrWordCount();
         //Gets each line till end of file is reached  
         while((line = br.readLine()) != null) { 
             //Splits each line into words  
              words = line.split(" ");
              root.buildTrie(words, root);
         } 
         root.printTrie(root, "");
    	 }catch(IOException ioe){
    		 ioe.printStackTrace();
    	 }
	}
}
