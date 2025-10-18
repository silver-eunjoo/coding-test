import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void combination(int start, int depth) {
        if(depth==M) {
            for(int num : selected) sb.append(num + " ");
            sb.append("\n");
            return;
        }
        
        for(int i=start;i<=N;i++){
            selected[depth] = i;
            combination(i, depth+1);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		combination(1, 0);
		bw.write(sb.toString());
		bw.flush();
	}
}