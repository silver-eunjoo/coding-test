import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10];
        int[] fruit = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int kind = 0;
        int max = 0;
        for(int right = 0; right < N; right++) {
            if(count[fruit[right]]++ == 0) kind++;
            while(kind > 2) {
                if(--count[fruit[left]] == 0) kind--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
		bw.write(String.valueOf(max));
		bw.flush();
	}
}