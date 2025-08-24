import java.io.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line = br.readLine();
        int N = Integer.parseInt(br.readLine());
        
        bw.write(line.charAt(N-1));
        bw.flush();
    }
}