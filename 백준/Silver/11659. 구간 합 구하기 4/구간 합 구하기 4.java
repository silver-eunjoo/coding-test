import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[] prefix = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		    prefix[i] = prefix[i-1] + arr[i];
		}
		while(M-->0) {
		    st = new StringTokenizer(br.readLine());
		    int i = Integer.parseInt(st.nextToken());
		    int j = Integer.parseInt(st.nextToken());
		    sb.append(prefix[j]-prefix[i-1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}