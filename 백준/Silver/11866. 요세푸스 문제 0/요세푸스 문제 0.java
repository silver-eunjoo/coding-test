import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> numList = new ArrayList<>();
		for(int i=0;i<N;i++) numList.add(i+1);
		int idx = 0;
		sb.append("<");
		while(N>0) {
		    if(sb.length()!=1) sb.append(", ");
		    idx = (idx + K - 1) % N;
		    sb.append(numList.get(idx));
		    numList.remove(idx);
		    N--;
		}
		bw.write(sb.toString());
		bw.write(">");
		bw.flush();
	}
}