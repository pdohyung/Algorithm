import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        int i = 0;
        
        // for(int i = 0; i < 20; i++) {
        //     System.out.println(Integer.toHexString(i));
        // }
        //for (int i = 0; i < (t * m); i++) {
        while (true) {
            //System.out.println(cnt);
            String s = Integer.toString(i, n).toUpperCase();
            //System.out.println(s);
            for (Character c : s.toCharArray()) {
                //System.out.println(c);
                if ((cnt % m) == p - 1) {
                    answer.append(c);
                }
                cnt++;
                
                if (answer.length() == t) {
                    break;
                }
            }
            
            i++;
            
            if (answer.length() == t) {
                    break;
            }
        }
        return answer.toString();
    }
    
}