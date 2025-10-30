import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] truck = new int[N];
		st = new StringTokenizer(br.readLine());
		Queue<Integer> bridge = new ArrayDeque<>();
		for(int i=0;i<N;i++){
		    truck[i] = Integer.parseInt(st.nextToken());
		}
		int time = 0;
		int weight = truck[0];
		bridge.offer(truck[0]);
		time++;
		for(int i=1;i<N;i++){
		    if(bridge.size()==W) {
		        int out = bridge.poll();
		        weight -= out;
		    }
		    if(weight + truck[i] <= L) {
		        weight+=truck[i];
		        bridge.offer(truck[i]);
		    } else {
		        bridge.offer(0);
		        i--;
		    }
		    time++;
		}
		bw.write(String.valueOf(time+W));
		bw.flush();
	}
}