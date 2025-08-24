import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            String line = br.readLine();
            int totalScore = 0;
            int score = 0;
            for(int j=0;j<line.length();j++){
                if(line.charAt(j) == 'O') {
                    score++;
                    totalScore += score;
                    continue;
                }
                score = 0;
            }
            bw.write(totalScore + "\n");
        }
        
        bw.flush();
	}
}