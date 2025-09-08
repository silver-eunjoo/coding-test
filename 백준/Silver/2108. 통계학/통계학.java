import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001];
        int max = -4001;
        int min = 4001;
        int total = 0;
        int maxCnt = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            total+=arr[i];
            count[arr[i]+4000]++;
            maxCnt = Math.max(maxCnt, count[arr[i]+4000]);
        }
        Arrays.sort(arr);
        int frequent = -1;
        int found = 0;
        for(int i=0;i<8001;i++){
            if(maxCnt == count[i]) {
                frequent = i-4000;
                found++;
            }
            if(found==2){
                break;
            }
        }
        sb.append(Math.round((double)total/N) + "\n");
        sb.append(arr[N/2]+"\n");
        sb.append(frequent + "\n");
        sb.append((max-min)+"\n");
        bw.write(sb.toString());
        bw.flush();
	}
}