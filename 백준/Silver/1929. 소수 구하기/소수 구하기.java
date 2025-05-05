import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        boolean isPrime = true;
        
        for(;m<=n;m++){
            for(int i=2;i<=(int)Math.sqrt(m);i++){
                if(m%i==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && m != 1){
                bw.write(m+"\n");
            }
            isPrime = true;
        }
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}