import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int findNumberOnlyWithOne(int num){
        StringBuffer sb = new StringBuffer();
        int count = 1;
        int base = 1;
        String numStr = sb.toString();
        
        while((base=base%num) != 0){
            count++;
            base = base*10 + 1;
        }
        
        return count;
    }
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str;
        
        while ((str = br.readLine()) != null && !str.trim().isEmpty()) {
            str = str.trim();
            bw.write(findNumberOnlyWithOne(Integer.parseInt(str))+"\n");
        }
        
        
        br.close();
        bw.flush();
        bw.close();
    }
}