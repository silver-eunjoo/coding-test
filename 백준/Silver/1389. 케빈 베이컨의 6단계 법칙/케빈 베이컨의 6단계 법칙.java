import java.util.*;
import java.io.*;

public class Main {
    static int INF = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		for(int i=0;i<=N;i++) Arrays.fill(arr[i], INF);
		while(M-->0) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    arr[a][b] = 1;
		    arr[b][a] = 1;
		}
		for(int k=1;k<=N;k++){
		    for(int i=1;i<=N;i++){
		        for(int j=1;j<=N;j++){
		            if(i==j) continue;
		            if(arr[i][k] + arr[k][j] < arr[i][j]) {
		                arr[i][j] = arr[i][k] + arr[k][j];
		            }
		        }
		    }
		}
		int minSum = Integer.MAX_VALUE;
		int answer = 0;
		for(int i=1;i<=N;i++){
		    int sum = 0;
		    for(int j=1;j<=N;j++){
		        sum+=arr[i][j];
		    }
		    if(minSum > sum) {
		        minSum = sum;
		        answer = i;
		    }
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}