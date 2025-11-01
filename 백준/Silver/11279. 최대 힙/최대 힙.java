import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(N-->0) {
            int command = Integer.parseInt(br.readLine());
            if(command == 0) {
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(command);
            }
        }
		bw.write(sb.toString());
		bw.flush();
	}
}