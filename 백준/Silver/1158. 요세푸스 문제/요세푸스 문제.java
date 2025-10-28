import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=N;i++){
		    list.add(i);
		}
		int idx = 0;
		sb.append("<");
		while(list.size()>1) {
		    idx= (idx + K -1)%(list.size());
		    idx = idx < 0 ? Math.abs(idx) : idx;
		    sb.append(list.get(idx)+", ");
		    list.remove(idx);
		}
		sb.append(list.get(0)+">");
		bw.write(sb.toString());
		bw.flush();
	}
}