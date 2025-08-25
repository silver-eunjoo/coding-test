import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        
        for(int i=0;i<26;i++){
            bw.write(word.indexOf((char)(97+i)) + " ");
        }
        bw.flush();
    }
}