import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] snack = new int[N];
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    snack[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snack);
		int maxLength = 0;
	    int min = 1;
		int max = snack[N-1];
		while(min<=max) {
		    int cnt=0;
		    int mid = (min+max) / 2;
		    for(int i=0;i<N;i++) cnt+=snack[i]/mid;
		    if(cnt<M) max = mid-1;
		    else {
		        maxLength = Math.max(maxLength, mid);
		        min = mid +1;
		    }
		}
		bw.write(String.valueOf(maxLength));
		bw.flush();
	}
}