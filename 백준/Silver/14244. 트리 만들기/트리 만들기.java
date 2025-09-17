import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 노드 수 
        int M = Integer.parseInt(st.nextToken()); // 리프 수
        int[][] edges = new int[N][2];
        int i;
        for(i=0;i<N-M+1;i++){
            edges[i][0] = i;
            edges[i][1] = i+1;
        }
        int left = M-1;
        while(left-->0) {
            edges[i][0] = N-M;
            edges[i][1] = ++i;
        }
        for(i=0;i<N-1;i++){
            sb.append(edges[i][0] + " " + edges[i][1] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}