import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}