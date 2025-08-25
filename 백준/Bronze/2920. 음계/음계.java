import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String music = br.readLine();
        
        StringTokenizer st = new StringTokenizer(music, " ");
        
        int firstNote = Integer.parseInt(st.nextToken());
        
        int diff = firstNote == 8 ? -1 : firstNote == 1 ? 1 : 0;
        
        if(diff==0) {
            bw.write("mixed");
            bw.flush();
            return;
        }
        
        int prevNote = firstNote;
        for(int i=0;i<7;i++){
            int note = Integer.parseInt(st.nextToken());
            
            if(prevNote + diff != note) {
                bw.write("mixed");
                bw.flush();
                return;
            }
            prevNote = note;
        }
        
        bw.write(firstNote==8?"descending":"ascending");
        bw.flush();
    }
}