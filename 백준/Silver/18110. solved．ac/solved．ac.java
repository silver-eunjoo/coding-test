import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		if(N==0) {
		    bw.write("0");
		    bw.flush();
		    return;
		}
		List<Integer> scoreList = new ArrayList<>();
		for(int i=0;i<N;i++){
		    scoreList.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(scoreList);
		int except = (int)Math.round(N*0.15);
	    List<Integer> trimmed = scoreList.subList(except, N-except);
		int total = 0;
		for(int i=0;i<N-2*except;i++){
		    total += trimmed.get(i);
		}
		int rank = (int)Math.round((double)total/trimmed.size());
		bw.write(String.valueOf(rank));
		bw.flush();
	}
}