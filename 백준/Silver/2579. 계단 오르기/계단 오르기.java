import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) stair[i] = Integer.parseInt(br.readLine());
		if(N==1) {
		    dp[1] = stair[1];
		} else if(N==2) {
		    dp[1] = stair[1];
		    dp[2] = stair[1] + stair[2];
		} else {
		    dp[1] = stair[1];
		    dp[2] = stair[1] + stair[2];
		    for(int i=3;i<=N;i++){
		        dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
		    }
		}
		bw.write(String.valueOf(dp[N]));
		bw.flush();
	}
}