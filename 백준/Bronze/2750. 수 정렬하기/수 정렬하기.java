import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		while(N-->0) {
		    q.offer(Integer.parseInt(br.readLine()));
		}
		while(!q.isEmpty()) {
		    sb.append(q.poll() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}