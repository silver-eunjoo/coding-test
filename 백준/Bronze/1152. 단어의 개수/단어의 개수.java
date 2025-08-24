import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String sentence = br.readLine().strip();
        if(sentence.isEmpty()) {
            bw.write(String.valueOf(0));
            bw.flush();
            return;
        }
        
        String[] words = sentence.split(" ");
        
        bw.write(String.valueOf(words.length));
        bw.flush();
    }
}