import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Set<String> line = new LinkedHashSet<>();
        for(int i=0;i<L;i++){
            String studentNum = br.readLine();
            line.remove(studentNum);
            line.add(studentNum);
        }
        for(String s : line) {
            if(K==0) break;
            sb.append(s+"\n");
            K--;
        }
        bw.write(sb.toString());
        bw.flush();
	}
}