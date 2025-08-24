import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        String line;
        
        while(true) {
            line = br.readLine();
            st = new StringTokenizer(line, " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0) {
                break;
            }
            
            bw.write(a + b + "\n");
        }
        bw.flush();
    }
}