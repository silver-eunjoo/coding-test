import java.io.*;
import java.util.*;

public class Main{
    static String[] L;
    static String[] R;
    static int idx = -1;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    L = st.nextToken().split("");
	    R = st.nextToken().split("");
	    bw.write(countEight()+"\n");
	    bw.flush();
	}
	static int countEight() {
	    if(L.length!=R.length) return 0;
	    int total = 0;
	    for(int i=0;i<L.length;i++){
	        if(!L[i].equals(R[i])) break;
	        if(L[i].equals("8")) total++;
	    }
	    return total;
	}
}