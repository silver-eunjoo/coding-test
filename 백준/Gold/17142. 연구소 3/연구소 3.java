import java.io.*;
import java.util.*;

public class Main
{
    static boolean[] selected;
    static int minTime = Integer.MAX_VALUE;
    static int empty = 0;
    static int M, N;
    static String[][] map;
    static List<int[]> virusList = new ArrayList<>();
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1};
    
    public static int bfs(){
        
        int zeroCnt = 0;
        int maxTime = 0;
        boolean[][] visited = new boolean[N][N];
        
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        for(int i=0;i<virusList.size();i++){
            if(selected[i]) {
                int[] activeVirus = virusList.get(i);
                deque.offer(new int[]{activeVirus[0], activeVirus[1], 0});
                visited[activeVirus[0]][activeVirus[1]] = true;
            }
        }
        
        while(!deque.isEmpty()) {
            int[] pos = deque.poll();
            
            for(int i=0;i<4;i++){ // 상하좌우
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny].equals("1")) continue;
                
                visited[nx][ny] = true;
                if(map[nx][ny].equals("0")) {
                    zeroCnt++;
                    maxTime = pos[2] + 1;
                }
                deque.offer(new int[]{nx, ny, pos[2] + 1});
            }
        }
        
        return zeroCnt == empty ? maxTime : -1;
    }
    
    public static void combination(int start, int depth) {
        if (depth == M) {
            int time  = bfs();
            if(time != -1) {
                minTime = Math.min(minTime, time);    
            }
            return;
        }
        
        for(int i=start;i<virusList.size();i++){
            selected[i] = true;
            combination(i+1, depth+1);
            selected[i] = false;
        }
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N][N];
		
		for(int i=0;i<N;i++){
		    line = br.readLine();
		    map[i] = line.split(" ");
		    for(int j=0;j<N;j++){
		        if(map[i][j].equals("0")) {
		            empty++;
		        } else if(map[i][j].equals("2")) {
		            virusList.add(new int[]{i, j});
		        }
		    }
		}
		
		selected = new boolean[virusList.size()];
		
		if(empty == 0) {
		    bw.write("0");
		} else {
		    combination(0, 0);
		    bw.write(minTime == Integer.MAX_VALUE ? "-1" : String.valueOf(minTime));
		}
		
		bw.flush();
	}
}