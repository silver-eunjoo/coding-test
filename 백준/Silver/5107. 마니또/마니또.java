import java.util.*;
import java.io.*;

public class Main {
    private static Map<String, String> manito;
    private static int findCycle() {
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for(String key : manito.keySet()) {
            if(set.contains(key)) continue;
            String start = key;
            while(true) {
                String next = manito.get(start);
                set.add(start);
                if(key.equals(next)) {
                    cnt++;
                    break;
                }
                start = next;
            }
        }
        return cnt;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N;
		manito = new HashMap<>();
		int T = 1;
		while(true) {
		    N = Integer.parseInt(br.readLine());
		    if(N==0) break;
		    manito = new HashMap<>();
		    while(N-->0) {
		        st = new StringTokenizer(br.readLine());
		        manito.put(st.nextToken(), st.nextToken());
		    }
		    sb.append(T++).append(" ").append(findCycle()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
