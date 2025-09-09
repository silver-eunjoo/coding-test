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
        Map<String, Integer> line = new LinkedHashMap<>();
        for(int i=0;i<L;i++){
            String studentNum = br.readLine();
            if(line.containsKey(studentNum)) line.remove(studentNum);
            line.put(studentNum, i);
            
        }
        Set<Map.Entry<String, Integer>> mapList = new HashSet<>(line.entrySet());
        for(Map.Entry<String, Integer> entry : line.entrySet()) {
            if(K==0) break;
            sb.append(entry.getKey() + "\n");
            K--;
            
        }
        bw.write(sb.toString());
        bw.flush();
	}
}