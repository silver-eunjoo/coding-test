import java.io.*;
import java.util.*;

public class Main{
    static int up;
    static int down;
    static int goal;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf((goal-down-1)/(up-down)+1));
        bw.flush();
	}
}