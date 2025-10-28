import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] expected = new int[N];
		for(int i=0;i<N;i++){
		    expected[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(expected);
		long sum = 0;
		for(int i=1;i<=N;i++){
		    sum+=Math.abs(i-expected[i-1]);
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}