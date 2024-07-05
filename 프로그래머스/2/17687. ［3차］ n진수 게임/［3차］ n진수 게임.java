import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int cur = 0;
        int tube = p;
        
        for(int i = 0; i <= t * m; i++) {
            String s = Integer.toString(i, n).toUpperCase();
            
            for (int j = 0; j < s.length(); j++) {
                cur++;
                
                if (cur == tube) {
                    answer += s.substring(j, j + 1);
                    if (answer.length() == t) break;
                    tube += m;
                }
            }
        }
        
        return answer;
    }
    
}