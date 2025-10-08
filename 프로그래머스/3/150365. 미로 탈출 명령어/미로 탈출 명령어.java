import java.util.*;

class Solution {
    private char[] dir = {'d', 'l', 'r', 'u'};
    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, -1, 1, 0};
    public int dist(int r, int c, int nX, int nY) {
        return Math.abs(r-nX) + Math.abs(c-nY);
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        
        if((k - dist(r, c, x, y))%2!=0) {
            return "impossible";
        }
        
        int curX = x;
        int curY = y;
        int nX, nY;
        int remain = k;
        
        for(int i=0;i<k;i++){
            for(int j=0;j<4;j++){
                nX = curX+dx[j];
                nY = curY+dy[j];
                if(nX <= 0 || nX > n || nY <=0 || nY > m) continue;
                int dist = dist(r, c, nX, nY);
                if(dist > remain-1 || (remain-1-dist)%2!=0) continue;
                curX = nX;
                curY = nY;
                remain--;
                sb.append(dir[j]);
                break;
            }
        }
        if(sb.toString().length()!=k) return "impossible";
        return sb.toString();
    }
}