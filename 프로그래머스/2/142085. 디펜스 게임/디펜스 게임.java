import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // emeny[i] 만큼 병사를 소비하여 막기 가능 -> 7 - 2 = 5
        // 라운드 스킵 k번 가능
        // 최대한 많은 라운드 진행하기
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int now = 0;
        int answer = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            now += enemy[i];
            pq.offer(enemy[i]);
            
            if (now > n) {
                if (k == 0) {
                    break;
                }
                
                k--;
                now -= pq.poll();
            }
            
            answer = i + 1;
        }
        
        return answer;
    }
}
