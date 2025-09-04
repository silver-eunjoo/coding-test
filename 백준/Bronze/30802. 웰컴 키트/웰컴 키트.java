import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<6;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=0;i<6;i++){
            count+= arr[i]%T==0? arr[i]/T : arr[i]/T +1;
        }
        sb.append(count+"\n");
        sb.append(N/P + " ");
        sb.append(N%P + "\n");
        bw.write(sb.toString());
        bw.flush();
	}
}