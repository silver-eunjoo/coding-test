import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] endurance;
    static int[] weight;
    static int[] order;
    static int maxBrokenEgg = 0;
    public static void countBrokenEggs(int idx, int brokenEgg) {
        if(idx==N) {
            maxBrokenEgg = Math.max(brokenEgg, maxBrokenEgg);
            return;
        }
        
        if(endurance[idx] <=0) {
            countBrokenEggs(idx +1, brokenEgg);
            return;
        }
        
        boolean possible = false;
        for(int i=0;i<N;i++){
            if(idx==i || endurance[i] <=0) continue;
            possible = true;
            endurance[idx] -= weight[i];
            endurance[i] -= weight[idx];
            int count = brokenEgg;
            if(endurance[idx] <=0) count++;
            if(endurance[i] <=0) count++;
            countBrokenEggs(idx+1, count);
            endurance[idx] += weight[i];
            endurance[i] += weight[idx];
        }
        if(!possible) {
            countBrokenEggs(N, brokenEgg);
            return;
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		endurance = new int[N];
		weight = new int[N];
		order = new int[N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    endurance[i] = Integer.parseInt(st.nextToken());
		    weight[i] = Integer.parseInt(st.nextToken());
		}
		countBrokenEggs(0, 0);
		bw.write(String.valueOf(maxBrokenEgg));
		bw.flush();
	}
}