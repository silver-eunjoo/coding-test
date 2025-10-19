import java.util.*;
import java.io.*;

public class Main {
    static int dp[];
    private static int solve(int N) {
        if(N<0) return -1;
        if(dp[N]!=0) return dp[N];
        if(N==3||N==5) {
            return dp[N];
        }
        int a = solve(N-3);
        int b = solve(N-5);
        if(a==-1 && b==-1) {
            dp[N] = -1;
        } else if(a==-1) {
            dp[N] = b + 1;
        } else if(b==-1){
            dp[N] = a + 1;
        } else {
            dp[N] = Math.min(a, b) + 1;
        }
        return dp[N];
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		dp = new int[Math.max(N+1, 6)];
		dp[3] = 1;
		dp[5] = 1;
		solve(N);
		bw.write(String.valueOf(dp[N]));
		bw.flush();
	}
}