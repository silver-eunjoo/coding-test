import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Map<Integer, Integer> candidate = new LinkedHashMap<>(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int minKey = 0;
		for(int i=0;i<M;i++){
		    int s = Integer.parseInt(st.nextToken());
		    if(candidate.size()==N && !candidate.containsKey(s)) {
		        minKey = 0;
		        min = Integer.MAX_VALUE;
		        for(int key : candidate.keySet()) {
		            min = Math.min(min, candidate.get(key));
		        }
		        for(int key : candidate.keySet()) {
		            minKey = key;
		            if(candidate.get(key)==min) break;
		        }
		        candidate.remove(minKey);
		    }
		    candidate.put(s, candidate.getOrDefault(s, 0) + 1);
		}
		Map<Integer, Integer> sortedMap = new TreeMap<>(candidate);
		for(int key : sortedMap.keySet()) {
		    sb.append(key + " ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}