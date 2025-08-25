import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = new int[8];
        
        String music = br.readLine();
        String type;
        
        StringTokenizer st = new StringTokenizer(music, " ");
        
        for(int i=0;i<8;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(Arrays.equals(ascending, arr)) {
            type = "ascending";
        } else if(Arrays.equals(descending, arr)) {
            type = "descending";
        } else {
            type = "mixed";
        }
        bw.write(type);
        bw.flush();
    }
}