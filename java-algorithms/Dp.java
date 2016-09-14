package ana;

import java.util.Scanner;

public class Dp {

	public static int countone(int n){
		 int count = 0;
	        while(n!=0){
	            n = n&(n-1);
	            count++;
	        }
	        return count;
		
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int [][]best;
		int N,M,Q;
		int []temp;
		int s;
		while(sc.hasNext()){
			N=sc.nextInt();
			M=sc.nextInt();
			Q=sc.nextInt();
			best=new int[N+1][(1<<N)+1];
			temp=new int[N+1];
			for(int i=1;i<=N;i++){
				temp[i]=sc.nextInt();
			}
			for(int i=0;i<=(1<<M);i++)
				best[0][i]=0;
			
			for(int i=1;i<=N;i++){
						for(int j=0;j<(1<<M);j++){   
                             int s0= ((j<<1)&((1<<M)-1)) ;
                             int s1=((j<<1 | 1)&((1<<M)-1));
                             best[i][s0]=Math.max(best[i][s0], best[i-1][j]);
                             if(countone(s1)<=Q){
                            	 best[i][s1]=Math.max(best[i][s1], best[i-1][j]+temp[i]);
                             }
				  }
			}
			int res=0;
			for(int i=0;i<(1<<M);i++){
				res=Math.max(res, best[N][i]);
			}
			System.out.println(res);
		}
	}
}
