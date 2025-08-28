import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int six = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;
        int price = 0;
        while(M-->0){
            st = new StringTokenizer(br.readLine(), " ");
            six = Math.min(Integer.parseInt(st.nextToken()), six);
            one = Math.min(Integer.parseInt(st.nextToken()), one);
        }
        if(N <= 6) price=Math.min(six, one*N);
        else if(N%6==0) price=Math.min(six*(N/6), one*N);
        else price=Math.min(six*(N/6+1), Math.min(six*(N/6)+one*(N%6), one*N));
        bw.write(String.valueOf(price));
        bw.flush();
    }
}