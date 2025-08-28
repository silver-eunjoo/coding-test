import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] lines = br.readLine().split(" ");
            if(Integer.parseInt(lines[0]) == 0) break;
            int[] t = new int[3];
            t[0] = Integer.parseInt(lines[0]);
            t[1] = Integer.parseInt(lines[1]);
            t[2] = Integer.parseInt(lines[2]);
            Arrays.sort(t);
            if(t[0]*t[0] + t[1]*t[1] == t[2]*t[2]) sb.append("right\n");
            else sb.append("wrong\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}