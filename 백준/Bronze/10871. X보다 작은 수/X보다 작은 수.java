import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line = br.readLine();
        
        StringTokenizer st = new StringTokenizer(line, " ");
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        line = br.readLine();
        st = new StringTokenizer(line, " ");
        
        for(int i=0;i<N;i++){
            int A = Integer.parseInt(st.nextToken());
            
            if(A < X) {
                bw.write(A + " ");
            }
        }
        bw.flush();
    }
}