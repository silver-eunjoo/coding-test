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
        Map<String, Integer> line = new HashMap<>();
        for(int i=0;i<L;i++){
            String studentNum = br.readLine();
            line.put(studentNum, i);
        }
        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(line.entrySet());
        mapList.sort((m1, m2) -> m1.getValue() - m2.getValue());
        for(int i=0;i<mapList.size();i++){
            if(K==0) break;
            sb.append(mapList.get(i).getKey() + "\n");
            K--;
        }
        bw.write(sb.toString());
        bw.flush();
	}
}