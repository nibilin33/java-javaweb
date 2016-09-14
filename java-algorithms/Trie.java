package ana;

public class Trie {
     public Trie[] childNodes;
     public int freq;
     public char nodeChar;
     public static int hash;
     public static Trie last;
     public Trie(){
    	childNodes=new Trie[26];
    	freq=0;
     }
     public void AddTrieNode(Trie root,String word){
    	 if(word.length()==0)
    	       return;
    	 int k=word.charAt(0)-'a';
    	 if(root.childNodes[k]==null){
    		 root.childNodes[k]=new Trie();
    		 root.childNodes[k].nodeChar=word.charAt(0);
    		 
    	 }else
    		 root.childNodes[k].freq++;
    	 String nextword=word.substring(1);
    	 AddTrieNode(root.childNodes[k], nextword);
     }
  
     public void searchword(Trie root ,String testword){
    	           if(testword.length()==0){
    	        	   hash=root.freq+1;
    	        	   return;
    	           }
    			  int k=testword.charAt(0)-'a';
    			  String nextword=testword.substring(1);
    			 
    			  if(root.childNodes[k]!=null){
    	            searchword(root.childNodes[k],nextword); 
    			  }else
    				  {
    				  hash=0;
    				  return;
    				  }
    		
				
     }
}
