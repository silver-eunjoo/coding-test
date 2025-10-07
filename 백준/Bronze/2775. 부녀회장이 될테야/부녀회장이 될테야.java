import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr = new int[15][15];
    public static int dp(int K, int N) {
        if(arr[K][N]!=0) return arr[K][N];
        for(int i=1;i<=N;i++){
            arr[K][N]=arr[K][N] + dp(K-1, i);
        }
        return arr[K][N];
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<15;i++){
            arr[0][i] = i;
        }
        while(T-->0) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            sb.append(dp(K, N) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}