import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static int N;
    static int K;
    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{arr[0], 1});
        
        while(!q.isEmpty()) {
            int[] target = q.poll();
            if(target[0]==K) return target[1];
            if(target[1]==N+1) return -1;
            int next = arr[target[0]];
            q.offer(new int[]{next, target[1]+1});
        }
        return -1;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        bw.write(bfs()+"\n");
        bw.flush();
	}
}