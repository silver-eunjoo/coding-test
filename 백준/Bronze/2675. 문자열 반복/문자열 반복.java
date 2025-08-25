import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb;
        
        for(int i=0;i<N;i++){
            String line = br.readLine();
            
            st = new StringTokenizer(line, " ");
            
            int X = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            
            String[] words = word.split("");
        
            sb = new StringBuilder();
            
            for(int j=0;j<words.length;j++){
                sb.append(words[j].repeat(X));
            }
            bw.write(sb.toString() + "\n");
        }
        
        
        bw.flush();
    }
}