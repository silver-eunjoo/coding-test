import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] endurance;
    static int[] weight;
    static int[] order;
    static int maxBrokenEgg = 0;
    public static void repeatPermut(int depth) {
        if(depth==N) {
            maxBrokenEgg = Math.max(maxBrokenEgg, simulation());
            return;
        }
        for(int i=0;i<N;i++){
            if(depth==i) continue;
            order[depth] = i;
            repeatPermut(depth + 1);
        }
    }
    public static int simulation() {
        int idx = 0;
        int[] tempE = endurance.clone();
        int[] tempW = weight.clone();
        for(int i=0;i<N &&idx<N;i++, idx++){
            int target = order[i];
            if(tempE[idx] <= 0 || tempE[target] <= 0) continue;
            tempE[idx]-=tempW[target];
            tempE[target]-=tempW[idx];
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(tempE[i] > 0) continue;
            cnt++;
        }
        return cnt;
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
		repeatPermut(0);
		bw.write(String.valueOf(maxBrokenEgg));
		bw.flush();
	}
}