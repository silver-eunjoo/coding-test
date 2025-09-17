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
        int i;
        for(i=0;i<N-M+1;i++){
            sb.append(i + " " + (i+1) + "\n");
        }
        int left = M-1;
        while(left-->0) {
            sb.append(N-M + " " + ++i + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}