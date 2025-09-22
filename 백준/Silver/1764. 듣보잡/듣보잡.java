import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Set<String> set1 = new TreeSet<>();
        int M = Integer.parseInt(st.nextToken());
        Set<String> set2 = new HashSet<>();
        while(N-->0) {
            set1.add(br.readLine());
        }
        while(M-->0) {
            set2.add(br.readLine());
        }
        set1.retainAll(set2);
        sb.append(set1.size() + "\n");
        for(String name: set1) sb.append(name+"\n");
        bw.write(sb.toString());
        bw.flush();
	}
}