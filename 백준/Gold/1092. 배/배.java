import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<M;i++){
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());
        
        if(cranes[0] < boxes.get(0)) {
            bw.write(String.valueOf(-1));
            bw.flush();
            return;
        }
        int sec = 0;
        int craneSize = cranes.length;
        while(!boxes.isEmpty()) {
            int craneIdx = 0;  
            int boxIdx = 0;
            while(craneIdx < craneSize) {
                if(boxIdx == boxes.size()) break;
                if(cranes[craneIdx] >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else boxIdx++;
            }
            sec++;
        }
        bw.write(String.valueOf(sec));
        bw.flush();
    }
}