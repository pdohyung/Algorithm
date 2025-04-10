import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length - 1; i++) bridge.add(0);
        bridge.add(truck_weights[0]);
        
        int cnt = 1;
        int time = 1;
        int total = truck_weights[0];
        
        while (!bridge.isEmpty()) {
            time++;
            
            total -= bridge.poll();
            
            if (cnt < truck_weights.length) {
                int now = truck_weights[cnt];
                if (now + total <= weight) {
                    bridge.add(now);
                    total += now;
                    cnt++;
                } else bridge.add(0);
            }
        }
        
        return time;
    }
}
