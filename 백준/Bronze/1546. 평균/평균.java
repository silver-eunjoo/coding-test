import java.io.*;
import java.util.*;

public class Main{
    static int zeroCnt = 0;
    static int one = 0;
    static int two = 0;
    static StringBuilder sbOne = new StringBuilder();
    static StringBuilder sbTwo = new StringBuilder();
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int M = arr[0];
        double total = 0;
        for(int i=0;i<N;i++){
            total+=(double)arr[i]/M*100;
        }
        bw.write(String.valueOf(total/N));
        bw.flush();
	}
}