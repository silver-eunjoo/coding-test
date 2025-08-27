import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        if(X > 0 && Y > 0) {
            bw.write(String.valueOf(1));
        } else if(X>0 && Y <0) {
            bw.write(String.valueOf(4));
        } else if(X < 0 && Y >0) {
            bw.write(String.valueOf(2));
        } else {
            bw.write(String.valueOf(3));
        }
        bw.flush();
    }
}