import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new ArrayList[N+1];
        int[] degree = new int[N+1];
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
            degree[a]++;
            degree[b]++;
        }
        int Q = Integer.parseInt(br.readLine());
        while(Q-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(t==1){
                if(degree[k]==1) sb.append("no").append("\n");
                else sb.append("yes").append("\n");
            } 
            else sb.append("yes").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}