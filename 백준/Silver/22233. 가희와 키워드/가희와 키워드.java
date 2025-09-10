import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> notes = new HashSet<>();
        while(N-->0) {
            notes.add(br.readLine());
        }
        while(M-->0){
            String[] input = br.readLine().split(",");
            for(int i=0;i<input.length;i++){
                notes.remove(input[i]);
            }
            sb.append(notes.size() + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}