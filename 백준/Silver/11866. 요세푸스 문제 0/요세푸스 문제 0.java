import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) q.offer(i+1);
		sb.append("<");
		while(!q.isEmpty()){
		    if(sb.length()!=1) sb.append(", ");
		    for(int i=0;i<K-1;i++){
		        int x = q.poll();
		        q.offer(x);
		    }
		    sb.append(q.poll());
		}
		bw.write(sb.toString());
		bw.write(">");
		bw.flush();
	}
}