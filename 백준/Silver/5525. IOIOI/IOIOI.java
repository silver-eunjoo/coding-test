import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		String input = br.readLine();
		for(int i=0;i<2*N+1;i++){
		    if(i%2==0) sb.append("I");
		    else sb.append("O");
		}
		int idx = 0;
		int count = 0;
		int find = 0;
		while(true) {
		    find = input.substring(idx).indexOf(sb.toString());
		    if(find==-1) break;
		    count++;
		    idx = find + 2 + idx;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
	}
}