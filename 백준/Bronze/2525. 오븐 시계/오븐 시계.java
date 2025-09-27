import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int pH = N/60;
        int pM = N%60;
        if(min + pM >= 60) {
            min = min + pM - 60;
            if(min==60) {
                pH++;
                min = 0;
            }
            if(hour+1+pH>=24) {
                hour = hour+1+pH - 24;
            } else {
                hour = hour + 1 + pH;
            }
        } else {
            min = min + pM;
            hour = hour + pH;
            if(hour>=24) {
                hour -=24;
            }
        }
        bw.write(hour + " " + min);
        bw.flush();
	}
}