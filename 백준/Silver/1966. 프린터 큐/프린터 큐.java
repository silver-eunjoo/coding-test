import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		Queue<int[]> q = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while(T-->0) {
		    q.clear();
		    pq.clear();
		    st = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    st = new StringTokenizer(br.readLine());
		    for(int i=0;i<N;i++){
		        int importance = Integer.parseInt(st.nextToken());
		        q.offer(new int[]{i, importance}); // index, importance
		        pq.offer(importance);
		    }
		    int count = 0;
		    while(!q.isEmpty()) {
		        int[] cur = q.poll();
		        if(cur[1] < pq.peek()) {
		            q.offer(cur);
		        } else {
		            pq.poll();
		            count++;
		            if(cur[0] == M) {
		                sb.append(count + "\n");
		                break;
		            }
		        }
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}