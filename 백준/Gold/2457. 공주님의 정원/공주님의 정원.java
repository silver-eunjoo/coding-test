import java.io.*;
import java.util.*;
public class Main
{
    static int toInt(int m, int d) {
        return m* 100 + d;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        String period;
        StringTokenizer st;
        
        int startMonth, startDay, endMonth, endDay;
        
        List<int[]> timeList = new ArrayList<>();
        
        int cnt = 0;
        
        for(int i=0;i<N;i++){
            period = br.readLine();
            st = new StringTokenizer(period, " ");
            
            startMonth = Integer.parseInt(st.nextToken());
            startDay = Integer.parseInt(st.nextToken());
            endMonth = Integer.parseInt(st.nextToken());
            endDay = Integer.parseInt(st.nextToken());
            
            int start = toInt(startMonth, startDay);
            int end = toInt(endMonth, endDay);
            
            timeList.add(new int[]{start, end});
        }
        
        // 시작 날짜 오름차순, 같으면 끝 날짜 내림차순
        timeList.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        
        int current = 301;
        int goal = 1201;
        int idx = 0;
        
        while(current < goal) {
            int best = current;
            boolean found = false;
            
            while(idx < N && timeList.get(idx)[0] <= current ) { // 시작 시간이 현재 시간보다 이전
                if( timeList.get(idx)[1] > best ) { // 끝나는 시간이 가장 긴 거 찾기
                    best = timeList.get(idx)[1];
                    found = true;
                }
                idx++;
            }
            
            if(!found) {
                bw.write("0");
                bw.flush();
                return;
            }
            
            cnt++;
            current = best;
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}