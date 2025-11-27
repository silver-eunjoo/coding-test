import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		String[] name = new String[N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    name[i] = st.nextToken();
		    arr[i][0] = i;
		    arr[i][1] = Integer.parseInt(st.nextToken());
		    arr[i][2] = Integer.parseInt(st.nextToken());
		    arr[i][3] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> {
		    if(a[1] != b[1]) return Integer.compare(b[1], a[1]);
		    if(a[2] != b[2]) return Integer.compare(a[2], b[2]);
		    if(a[3] != b[3]) return Integer.compare(b[3], a[3]);
		    return name[a[0]].compareTo(name[b[0]]);
		});
		for(int i=0;i<N;i++){
		    sb.append(name[arr[i][0]]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}