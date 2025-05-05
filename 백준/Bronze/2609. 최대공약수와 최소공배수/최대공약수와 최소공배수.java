import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int gcd = 0;
        int lcm = 0;
        
        for(int i=a;i>=1;i--){
            if(a%i == 0 && b%i == 0){
                gcd = i;
                break;
            }
        }
        
        lcm = (a/gcd) * (b/gcd) * gcd;
        
        bw.write(gcd+"\n");
        bw.write(lcm+"\n");
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}