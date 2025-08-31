import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fizzBuzz = new String[3];
        int num = 0;
        int idx = 0;
        for(int i=0;i<3;i++){
            fizzBuzz[i] = br.readLine();
            idx = 0;
            while(idx<fizzBuzz[i].length()){
                if(!Character.isDigit(fizzBuzz[i].charAt(idx))) {
                    break;
                }
                idx++;
            }
            if(idx==fizzBuzz[i].length()) {
                idx=i;
                num=Integer.parseInt(fizzBuzz[i]);
                break;
            }
        }
        num = num+3-idx;
        if(num%3==0&&num%5==0) bw.write("FizzBuzz");
        else if(num%3==0&&num%5!=0) bw.write("Fizz");
        else if(num%3!=0&&num%5==0) bw.write("Buzz");
        else bw.write(String.valueOf(num));
        bw.flush();
	}
}