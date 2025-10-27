import java.util.*;
import java.io.*;

public class Main {
    static boolean[] traveled;
    static List<Integer>[] plane;
    static int N;
    static int M;
    static int cnt = 0;
    public static void dfs(int start) {
        traveled[start] = true;
        for(int i=0;i<plane[start].size();i++){
            if(traveled[plane[start].get(i)]) continue;
            dfs(plane[start].get(i));
            cnt++;
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
		    cnt=0;
		    StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		plane = new ArrayList[N+1];
    		for(int i=1;i<=N;i++){
    		    plane[i] = new ArrayList<>();
    		}
    		traveled = new boolean[N+1];
    		for(int i=0;i<M;i++){
    		    st = new StringTokenizer(br.readLine());
    		    int a = Integer.parseInt(st.nextToken());
    		    int b = Integer.parseInt(st.nextToken());
    		    plane[a].add(b);
    		    plane[b].add(a);
    		}
    		for(int i=1;i<=N;i++){
    		    if(traveled[i]) continue;
    		    dfs(i);
    		}
    		sb.append(cnt + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}