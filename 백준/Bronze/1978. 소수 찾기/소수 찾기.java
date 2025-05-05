import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        boolean isPrime = true;
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            isPrime = true;
            for(int j=2;j<=(int)Math.sqrt(temp);j++){
                if(temp%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && temp != 1){
                answer++;
            }
        }
        
        bw.write(answer+"\n");
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}