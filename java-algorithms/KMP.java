package ana;

import java.util.Scanner;

public class KMP {
	private String pat;
	public int next[];
	private int M;
	private int count;

	public KMP(String pat) {
		super();
		this.pat = pat;
		count = 0;
		next = new int[pat.length() + 1];
		next[0] = -1;

		M = -1;
		int i = 0;
		while (i < pat.length()) {
			if (M == -1 || pat.charAt(i) == pat.charAt(M)) {
				++M;
				++i;
				next[i] = M;
			} else
				M = next[M];
		}
		// for(int i=1;i<pat.length();i++){
		// while(M>0&&pat.charAt(M)!=pat.charAt(i)){
		// M=next[i];
		// }
		// if(pat.charAt(M)==pat.charAt(i)){
		// M++;
		// }
		// next[i]=M;
		// }

	}

	public int search(String test) {
		int n = pat.length();
		int m = test.length();
		count = 0;
		int j, i;
		i = j = 0;
		while (i < m) {
			if (j == -1 || pat.charAt(j) == test.charAt(i)) {
				i++;
				j++;
			} else if (j < n) {
				j = next[j];
			}
			if (j == n) {
				count++;
				j = next[j];
			}

		}
		// for(int i=0;i<test.length();i++){
		// if(test.charAt(i)==pat.charAt(j)){
		// j++;
		// }else
		// {
		//
		// j=next[j];
		//
		// }
		//
		// if(j==pat.length()){
		// count++;
		// i=i-next[j-1];
		// j=next[j-1];
		// }
		//
		// }
		return count;
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N;
		String patern,text;
		while(sc.hasNext()){
			N=sc.nextInt();
			for(int i=0;i<N;i++){
				patern=sc.next();
				text=sc.next();
				KMP kmp=new KMP(patern);
				  System.out.println(kmp.search(text));
			}
		}
        
      
     
        
	}

}
