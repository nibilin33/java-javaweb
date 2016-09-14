package ana;

import java.util.Scanner;

public class bag01Improve {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		  int N;
		  int W;
	      int []best;
	      int [] need;
	      int [] likevalue;
	      Scanner sc=new Scanner(System.in);
	      while(sc.hasNext()){
	    	  N=sc.nextInt();
	    	  W=sc.nextInt();
	    	  need=new int[N+1];
	    	  likevalue=new int[N+1];
	    	  best=new int[W+1];
	    	  for(int i=1;i<=N;i++){
	    		need[i]=sc.nextInt();
	    		likevalue[i]=sc.nextInt();
	    	  }
	    	  for(int i=0;i<=W;i++){
	    	  best[i]=0;
	    	  }
	    	  for(int i=1;i<=N;i++){
	    		for(int j=W;j>=need[i];j--){
	    				best[j]=Math.max(best[j], best[j-need[i]]+likevalue[i]);
	    				
	    	  }
	    	  }
	    	  System.out.println(best[W]);
	   
	     
	      }

	}

}
