import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        int num = 1;
        int pos = 0;
        while(pos<target.length()) {
            String numStr = String.valueOf(num);
            for(int i=0;i<numStr.length();i++){
                if(pos<target.length() && target.charAt(pos)==numStr.charAt(i)){
                    pos++;
                }
            }
            num++;
        }
        bw.write(String.valueOf(num-1));
        bw.flush();
	}
}