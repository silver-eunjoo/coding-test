import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<Integer> num = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while(N-->0) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while(M-->0){
            if(num.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
            else sb.append("0\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}