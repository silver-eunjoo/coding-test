import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] hotel = new int[H*W][2];
            int idx = 0;
            for(int i=1;i<=H;i++){
                for(int j=1;j<=W;j++){
                    hotel[idx][0] = i;
                    hotel[idx++][1] = j;
                }
            }
            Arrays.sort(hotel, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            bw.write(hotel[N-1][0]*100+hotel[N-1][1] + "\n");
        }
        bw.flush();
    }
}