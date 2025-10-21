import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N];
		Set<Integer> selected = new HashSet<>();
		int[] count = new int[d+1];
		int max = 0;
		for(int i=0;i<N;i++){
		    sushi[i] = Integer.parseInt(br.readLine());
		    if(i<k){
		        selected.add(sushi[i]);
		        count[sushi[i]]++;
		    } 
		}
		max = count[c]==0?selected.size()+1:selected.size();
		for(int i=k;i<k+N-1;i++){
		    int out = sushi[(i-k)%N];
		    int in = sushi[i%N];
		    if(count[out] == 1) selected.remove(out);
		    count[out]--;
		    if(count[in]==0) selected.add(in);
		    count[in]++;
		    max = Math.max(max, count[c]==0?selected.size()+1:selected.size());
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}