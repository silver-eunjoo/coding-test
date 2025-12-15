import java.util.*;
import java.io.*;

public class Main {
    private static Map<String, String> manito;
    private static int findCycle() {
        int cnt = 0;
        Set<String> visited = new HashSet<>();
        for(String start : manito.keySet()) {
            if(visited.contains(start)) continue;
            Set<String> path = new HashSet<>();
            String cur = start;
            while(!visited.contains(cur)) {
                visited.add(cur);
                path.add(cur);
                cur = manito.get(cur);
                if(path.contains(cur)) {
                    cnt++;
                    break;
                }
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
