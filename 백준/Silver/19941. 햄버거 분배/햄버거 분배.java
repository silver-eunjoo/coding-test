import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String table = br.readLine();
        List<Integer> H = new ArrayList<>();
        List<Integer> P = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(table.charAt(i)=='H') H.add(i);
            else P.add(i);
        }
        int i=0;
        int j=0;
        int cnt = 0;
        while(i<H.size() && j<P.size()){
            int h = H.get(i);
            int p = P.get(j);
            if(Math.abs(h-p)<=K) {
                cnt++;
                i++;
                j++;
                continue;
            }
            if(p>h) i++;
            else j++;
        } 
        bw.write(String.valueOf(cnt));
        bw.flush();
	}
}