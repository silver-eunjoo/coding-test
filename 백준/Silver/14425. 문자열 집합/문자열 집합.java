import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		while(N-->0) {
		    set.add(br.readLine());
		}
		int cnt = 0;
		while(M-->0) {
		    String input = br.readLine();
		    if(set.contains(input)) cnt++;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}