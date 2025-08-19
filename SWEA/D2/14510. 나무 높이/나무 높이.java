import java.util.*;
import java.io.*;

public class Solution {

	static int N, T;
	static int[] trees;
	static int max, oneCnt, twoCnt, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			trees = new int[N];
			st = new StringTokenizer(br.readLine());
			
			max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			oneCnt = 0; twoCnt = 0;
			for(int i=0;i<N;i++) {
				int r = max - trees[i];
				oneCnt += r%2;
				twoCnt += r/2;
			}
			
			// System.out.println(oneCnt + " " + twoCnt);
			
			int diff = twoCnt - oneCnt;
			if(diff >= 2) {
				int change = (diff+1)/3;
				twoCnt -= change;
				oneCnt += 2*change;
			} 

			if(twoCnt >= oneCnt) {
				ans = twoCnt * 2;
			} else if(twoCnt < oneCnt) {
				ans = (oneCnt-1) * 2 + 1;
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}
