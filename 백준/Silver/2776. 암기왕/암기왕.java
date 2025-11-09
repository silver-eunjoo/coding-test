import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] real;
    static int[] guess;
    private static int upperBound(int x) {
        int left = 0;
        int right = N;
        while(left < right) {
            int mid = (left+right) /2;
            if(real[mid]<=x) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    private static int lowerBound(int x) {
        int left = 0;
        int right = N;
        while(left < right) {
            int mid = (left+right)/2;
            if(real[mid]<x) left = mid + 1;
            else right = mid;
        }
        return left;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
		    N = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine());
		    real = new int[N];
		    for(int i=0;i<N;i++) real[i] = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine());
		    guess = new int[M];
		    for(int i=0;i<M;i++) guess[i] = Integer.parseInt(st.nextToken());
		    Arrays.sort(real);
		    for(int i=0;i<M;i++){
		        sb.append(upperBound(guess[i]) - lowerBound(guess[i]) > 0 ? "1 " : "0 ");
		    }
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}