import java.io.*;
import java.util.*;

public class Main{
    static String L;
    static String R;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    L = st.nextToken();
	    R = st.nextToken();
	    bw.write(countEight()+"\n");
	    bw.flush();
	}
	static int countEight() {
	    if(L.length()!=R.length()) return 0;
	    int total = 0;
	    for (int i = 0; i<L.length(); i++) {
	        if (L.charAt(i) != R.charAt(i)) break;
	        if (L.charAt(i) == '8') total++; 
	    } 
	    return total;
	}
}