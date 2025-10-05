import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Map<String, String> keyMap = new HashMap<>();
        while(N-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            String web = st.nextToken();
            String pwd = st.nextToken();
            keyMap.put(web, pwd);
        }
        while(T-->0) {
            sb.append(keyMap.get(br.readLine()) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}