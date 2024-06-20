import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;

        for(int i : priorities) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (q.peek() == priorities[i]) {
                    q.poll();
                    res++;
                    
                    if (location == i) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}