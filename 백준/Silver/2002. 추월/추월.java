import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> inMap = new LinkedHashMap<>();
		Map<String, Integer> outMap = new HashMap<>();
		for(int i=0;i<N;i++){
		    inMap.put(br.readLine(), i);
		}
		int cnt = 0;
		for(int i=0;i<N;i++){
		    String car = br.readLine();
		    int order = inMap.get(car);
		    outMap.put(car, i);
		    if(order > i) {
		        cnt++;
		        continue;
		    }
		    int j=0;
		    for(String key : inMap.keySet()) {
		        if(j++==order) break;
		        if(outMap.containsKey(key)) continue;
		        else {
		            cnt++;
		            break;
		        }
		    }
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}