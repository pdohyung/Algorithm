import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int cnt = 0;
        long total = 0;
        long sum1 = 0, sum2 = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
            total += queue1[i] + queue2[i];
        }
        
        long half = total / 2;
        // System.out.println(half);
        
        while(true) {
            // 어떤 방법을 쓰더라도, 합을 같게 만들 수 없는 경우
            if(cnt > queue1.length * 2 + 2) {
                cnt = -1;
                break;
            }
            
            if(sum1 == sum2) {
                break;            
            }
            else if(sum1 < sum2) {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
                cnt++;
            } 
            else if(sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
                cnt++;
            }
        }
        
        return cnt;
    }
}