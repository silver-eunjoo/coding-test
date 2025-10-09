import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            q.offer(i);
        }
        while(q.size()!=1) {
            q.poll();
            int x = q.poll();
            q.offer(x);
        }
        bw.write(String.valueOf(q.poll()));
        bw.flush();
	}
}