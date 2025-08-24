import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String time = br.readLine();
        StringTokenizer st = new StringTokenizer(time, " ");
        
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        
        if(min-45<0) {
            min = 60 + min - 45;
            if(hour-1 < 0) {
                hour = 23;
            }
            else {
                hour-=1;
            }
        } else {
            min-=45;
        }
        
        bw.write(hour + " " + min);
        bw.flush();
    }
}