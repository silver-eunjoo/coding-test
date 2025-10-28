import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> inMap = new LinkedHashMap<>();
		for(int i=0;i<N;i++){
		    inMap.put(br.readLine(), i);
		}
		int cnt = 0;
		int[] out = new int[N];
		for(int i=0;i<N;i++){
		    out[i] = inMap.get(br.readLine());
        }
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(out[i] > out[j]) {
                    cnt++;
                    break;
                }
            }
        }
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}