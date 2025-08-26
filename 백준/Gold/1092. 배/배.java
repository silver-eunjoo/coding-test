import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> cranes = new ArrayList<>();;
    static List<Integer> boxes = new ArrayList<>();;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<M;i++){
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());
        cranes.removeIf(x -> x < boxes.get(M-1));
        bw.write(String.valueOf(findMinTime()));
        bw.flush();
    }
    
    static int findMinTime() {
        if(cranes.isEmpty()) return -1;
        if(cranes.get(0) < boxes.get(0)) return -1;
        int sec = 0;
        int craneSize = cranes.size();
        while(!boxes.isEmpty()) {
            int craneIdx = 0;  
            int boxIdx = 0;
            while(craneIdx < craneSize) {
                if(boxIdx == boxes.size()) break;
                if(cranes.get(craneIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else boxIdx++;
            }
            sec++;
        }
        return sec;
    }
}