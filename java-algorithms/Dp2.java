package ana;

import java.util.Arrays;
import java.util.Scanner;

public class Dp2 {
    public static int mod=1000000007;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
       int N,M;
       int mxx,mx;
       Scanner sc=new Scanner(System.in);
	   int [][]dp;
		while(sc.hasNext()){
			N=sc.nextInt();
			M=sc.nextInt();
			mxx=(1<<(1<<M));
			mx=(1<<M)-1;
			dp=new int[N+1][mxx+1];
			for(int i=0;i<N;i++)
		     Arrays.fill(dp[i], 0);
			dp[0][0]=1;
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					for(int k=0;k<mxx;k++){
						if(((1<<j)&k)==0){
							if(j!=M-1&&((1<<(j+1))&k)==0){
								dp[i][k|1<<j|(1<<(j+1))]=(dp[i][k|1<<j|1<<(j+1)]+dp[i][j])%mod;
							}
							dp[i][k|1<<(j+M)|(1<<j)]=(dp[i][k|1<<(j+M)|1<<j]+dp[i][j])%mod;
						}
					}
					
				}
				for(int k=0;k<mxx;k++){
					if((k&mx)==mx){
						dp[i+1][k>>M]=dp[i][k];
					}
				}
			}
			System.out.println(dp[N-1][mx]/2);
		}
	}

}
