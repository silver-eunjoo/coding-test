import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int pos = 0;
        String table = br.readLine();
        boolean[] eaten = new boolean[N];
        int cnt = 0;
        while(pos<N) {
            if(table.charAt(pos)!='H'){
                pos++;
                continue;
            }
            for(int i=-K;i<=K;i++){
                if(pos+i<0||pos+i>=N) continue;
                if(!eaten[pos+i] && table.charAt(pos+i)=='P') {
                    eaten[pos+i] = true;
                    eaten[pos] = true;
                    cnt++;
                    break;
                }
            }
            pos++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
	}
}