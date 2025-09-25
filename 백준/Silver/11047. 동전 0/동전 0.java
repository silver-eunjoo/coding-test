import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        for(int i=0;i<N;i++) money[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=N-1;i>=0;i--) {
            if(K==0) break;
            if(K/money[i]==0) continue;
            cnt+=K/money[i];
            K = K - (K/money[i])*money[i];
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
	}
}