import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int lines = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[lines][2];
		
		for(int i=0;i<lines;i++){
		    String point = br.readLine();
		    st = new StringTokenizer(point, " ");
		    
		    arr[i][0] = Integer.parseInt(st.nextToken());
		    arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (n1, n2) -> {
		    return n1[0] - n2[0];
		});
		
		int min = arr[0][0];
		int max = arr[0][1];
		
		int totalLength = 0;
		
		for(int i=1;i<lines;i++){ 
		    if(max >= arr[i][0]) { // 범위가 포함되면..?
		        max = Math.max(max, arr[i][1]);
		        continue;
		    }
		    // 범위 포함 안됨. 다음 구간으로 넘어가 ~ 
		    totalLength += max - min;
		    min = arr[i][0];
		    max = arr[i][1];
		}
		
		totalLength += max - min;
		
		
		bw.write(String.valueOf(totalLength));
		
        bw.flush();
	}
}