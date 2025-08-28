import java.io.*;
import java.util.*;

public class Main{
    static int zeroCnt = 0;
    static int one = 0;
    static int two = 0;
    static StringBuilder sbOne = null;
    static StringBuilder sbTwo = null;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            Integer[] arr = new Integer[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());
            zeroCnt = 0;
            one = 0;
            two = 0;
            int idx = 0;
            for(int i=0;i<N;i++){
                if(arr[i]==0){
                    zeroCnt=N-i;
                    sbOne = new StringBuilder(Integer.toString(one));
                    sbTwo = new StringBuilder(Integer.toString(two));
                    break;
                }
                if(i%2==0){
                    two += arr[i]*Math.pow(10, idx);
                    continue;
                }
                one += arr[i]*Math.pow(10, idx);
                idx++;
            }
            bw.write(addTwoNums()+"\n");
        }
        bw.flush();
	}
	
	static int addTwoNums() {
	    if(zeroCnt==0) return one+two;
	    while(zeroCnt-->0) {
            if(one>two) {
                sbTwo.insert(1, "0");
                two = Integer.parseInt(sbTwo.toString());
                continue;
            }
            sbOne.insert(1, "0");
            one = Integer.parseInt(sbOne.toString());
        }
        return one+two;
	}
}