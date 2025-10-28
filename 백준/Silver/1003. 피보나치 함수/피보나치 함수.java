import java.util.*;
import java.io.*;

public class Main {
    static int[] one = new int[41];
    static int[] zero = new int[41];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		one[0] = 0; // fib(0)
		zero[0] = 1;
		zero[1] = 0; // fib(1)
		one[1] = 1;
		for(int i=2;i<=40;i++){
		    one[i] = one[i-2] + one[i-1];
		    zero[i] = zero[i-2] + zero[i-1];
		}
		while(T-->0) {
    		int N = Integer.parseInt(br.readLine());
    		sb.append(zero[N]).append(" ").append(one[N]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}