import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] tree;
    static long totalDepth = 0;
    public static long dfs(int now, int prev, long depth) {
        if(tree[now].size()==1 && tree[now].get(0) == prev) return depth;
        for(Integer node : tree[now]) {
            if(node!=prev) {
                long dist = dfs(node, now, depth+1);
                totalDepth+=dist;
            }
        }
        return 0;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
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
        dfs(1, 0, 0);
        bw.write(totalDepth%2==0?"No":"Yes");
        bw.flush();
	}
}