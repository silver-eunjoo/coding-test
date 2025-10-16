import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] endurance;
    static int[] weight;
    static int[] order;
    static int maxBrokenEgg = 0;
    public static void dfs(int idx) {
        if(idx==N) {
            int count = 0;
            for(int i=0;i<N;i++){
                if(endurance[i] <= 0) count++;
            }
            maxBrokenEgg = Math.max(count, maxBrokenEgg);
            return;
        }
        
        if(endurance[idx] <= 0) {
            dfs(idx+1);
            return;
        }
        
        boolean allBroken = true;
        for(int i=0;i<N;i++){
            if(idx!=i && endurance[i] > 0) {
                allBroken = false;
                break;
            }
        }
        if(allBroken) {
            dfs(N);
            return;
        }
        
        for(int i=0;i<N;i++){
            if(idx==i) continue;
            if(endurance[i] <= 0) continue;
            endurance[idx] -= weight[i];
            endurance[i] -= weight[idx];
            dfs(idx+1);
            endurance[idx] += weight[i];
            endurance[i] += weight[idx];
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
		dfs(0);
		bw.write(String.valueOf(maxBrokenEgg));
		bw.flush();
	}
}