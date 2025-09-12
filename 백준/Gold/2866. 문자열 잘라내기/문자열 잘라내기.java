import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        int count = 0;
        String[] input;
        for(int i=0;i<R;i++){
            input = br.readLine().split("");
            for(int j=0;j<C;j++){
                map.put(j, map.getOrDefault(j, "") + input[j]); 
            }
        }
        LinkedHashSet<String> set = new LinkedHashSet<>(map.values());
        LinkedHashSet<String> temp;
        for(int i=0;i<R;i++){
            temp = new LinkedHashSet<>();
            for(String s : set) {
                temp.add(s.substring(1, s.length()));
            }
            if(temp.size()==C) {
                set = temp;
                count++;
            }
            else break;
        }
        bw.write(String.valueOf(count));
        bw.flush();
	}
}