import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] tree;
    static boolean[] visited;
    static int totalDepth = 0;
    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            boolean isLeaf = true;
            for(int next : tree[cur[0]]) {
                if(visited[next]) continue;
                visited[next] = true;
                isLeaf = false;
                q.offer(new int[]{next, cur[1]+1});
            }
            if(isLeaf) totalDepth+=cur[1];
        }
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        bfs();
        bw.write(totalDepth%2==0?"No":"Yes");
        bw.flush();
	}
}