import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for(int i=0;i<N;i++){
            String line = br.readLine();
            st = new StringTokenizer(line, " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            bw.write(a + b + "\n");
        }
        bw.flush();
    }
}