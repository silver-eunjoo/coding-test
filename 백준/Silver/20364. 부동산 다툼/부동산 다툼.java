import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] occupied = new boolean[N+1];
        while(Q-->0) {
            int D = Integer.parseInt(br.readLine());
            int answer = 0;
            int temp = D;
            while(temp!=1) {
                if(occupied[temp]) answer = temp;
                temp >>= 1;
            }
            occupied[D] = true;
            sb.append(answer+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}