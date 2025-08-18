import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int level = Integer.parseInt(br.readLine());
		
		int score[] = new int[level];
		
		int prev = -1;
		
		int move = 0;
		
		for(int i=0;i<level;i++){
		    score[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=level-1;i>0;i--) {
		    if(score[i] <= score[i-1]) {
		        move += score[i-1] - score[i] + 1;
		        score[i-1] = score[i] - 1;
		    }
		}
		
		
		bw.write(move+"");
		br.close();
        bw.flush();
        bw.close();
		
	}
}