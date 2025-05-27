import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> deleted = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        
        for (String c : cmd) {
            String[] line = c.split(" ");
            String oper = line[0];
            
            if (oper.equals("U")) {
                int cnt = Integer.parseInt(line[1]);
                while (cnt-- > 0) k = prev[k];
            } else if (oper.equals("D")) {
                int cnt = Integer.parseInt(line[1]);
                while (cnt-- > 0) k = next[k];
            } else if (oper.equals("C")) {
                deleted.push(k);
                
                if (next[k] != -1) prev[next[k]] = prev[k];
                if (prev[k] != -1) next[prev[k]] = next[k];
                
                if (next[k] == -1) k = prev[k];
                else k = next[k];
            } else {
                int now = deleted.pop();
                
                if (next[now] != -1) prev[next[now]] = now;
                if (prev[now] != -1) next[prev[now]] = now;
            }
            
            // System.out.println(k);
            // System.out.println(Arrays.toString(prev));
            // System.out.println(Arrays.toString(next));
            // System.out.println();
        }
        
        // System.out.println(deleted);
        
        StringBuilder answer = new StringBuilder();
        boolean[] removed = new boolean[n];
        
        for (int d : deleted) {
            removed[d] = true;
        }

        for (int i = 0; i < n; i++) {
            if (removed[i]) answer.append('X');
            else answer.append('O');
        }
        
        return answer.toString();
    }
}
