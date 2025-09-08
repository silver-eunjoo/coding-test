import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> closet;
        while(T-->0){
            closet = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            while(N-->0){
                String[] input = br.readLine().split(" ");
                closet.put(input[1], closet.getOrDefault(input[1], 0) + 1);
            }
            int result = 1;
            for(String key : closet.keySet()) {
                result *=closet.get(key)+1;
            }
            sb.append(result-1 + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}