import java.io.*;
import java.util.*;

public class Main
{
    static boolean[] selected;
    static int minTime = Integer.MAX_VALUE;
    static int empty = 0;
    
    public static int bfs(String[][] map, int M, int N, List<int[]> virusList){
        
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1};
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[N][N];
        
        for(int i=0;i<virusList.size();i++){
            if(selected[i]) {
                int[] pos = virusList.get(i);
                q.offer(new int[]{pos[0], pos[1], 0});
                visited[pos[0]][pos[1]] = true;
            }
        }
        
        int maxTime = 0;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            for(int i=0;i<4;i++){ // 상하좌우
                int tempX = pos[0] + dx[i];
                int tempY = pos[1] + dy[i];
                
                if(tempX >=0 && tempX < N && tempY >= 0 && tempY <N && !visited[tempX][tempY] && !map[tempX][tempY].equals("-")) {
                    visited[tempX][tempY] = true;
                    if(map[tempX][tempY].equals("0")) {
                        cnt++;
                        maxTime = pos[2]+1; // 빈칸일 때만
                    } 
                    q.offer(new int[]{tempX, tempY, pos[2] + 1});
                    
                }
            }
        }
        
        return cnt == empty ? maxTime : -1;
    }
    
    public static void combination(int start, int depth, int M, String[][] map, List<int[]> virusList, int N) {
        if (depth == M) {
            int time  = bfs(map, M, N, virusList);
            if(time != -1) {
                minTime = Math.min(minTime, time);    
            }
            return;
        }
        
        for(int i=start;i<virusList.size();i++){
            selected[i] = true;
            combination(i+1, depth+1, M, map, virusList, N);
            selected[i] = false;
        }
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] map = new String[N][N];
		
		List<int[]> virusList = new ArrayList<>();
		
		for(int i=0;i<N;i++){
		    line = br.readLine();
		    map[i] = line.split(" ");
		    for(int j=0;j<N;j++){
		        if(map[i][j].equals("0")) {
		            empty++;
		        }
		        else if(map[i][j].equals("1")){
		            map[i][j] = "-"; 
		        }
		        else {
		            virusList.add(new int[]{i, j});
		        }
		    }
		}
		
		selected = new boolean[virusList.size()];
		
		if(empty == 0) {
		    bw.write("0");
		} else {
		    combination(0, 0, M, map, virusList, N);
		    bw.write(minTime == Integer.MAX_VALUE ? "-1" : String.valueOf(minTime));
		}
		
		bw.flush();
	}
}