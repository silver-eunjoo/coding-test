import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int truck = cap;
        int dist = 0;
        boolean found = true;
        int dEnd = n-1;
        int pEnd = n-1;
        while(found) {
            dist = 0;
            found = false;
            truck = cap;
            for(int i=dEnd;i>=0 && truck!=0;i--){
                while(truck!=0 && deliveries[i]!=0) {
                    deliveries[i]--;
                    truck--;
                    dist = Math.max(dist, i+1);
                    found = true;
                    dEnd = Math.min(dEnd, i);
                }
            }
            truck = cap;
            for(int i=pEnd;i>=0 && truck!=0;i--){
                while(truck!=0 && pickups[i]!=0) {
                    pickups[i]--;
                    truck--;
                    dist = Math.max(dist, i+1);
                    found = true;
                    pEnd = Math.min(pEnd, i);
                }
            }
            answer+= dist*2;
        }
        return answer;
    }
}