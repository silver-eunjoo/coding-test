import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        while(N-->1) {
            set.remove(st.nextToken());
        }
        for(String s : set) bw.write(s);
        bw.flush();
	}
}