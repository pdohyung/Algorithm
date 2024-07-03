import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] width;
    static boolean[] diagonal1;
    static boolean[] diagonal2;
    static int N;
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        diagonal1 = new boolean[n * 2];
        diagonal2 = new boolean[n * 2];
        int answer = findAns(0);
        
        return answer;
    }
    
    static int findAns(int y) {
        int ans = 0;
        
        if(y == N) {
            ans++;
        } else {
            for(int i = 0; i < N; i++) {
                if (width[i] || diagonal1[i + y] || diagonal2[i - y + N]) {
                    continue;
                }
                width[i] = diagonal1[i + y] = diagonal2[i - y + N] = true;
                ans += findAns(y + 1);
                width[i] = diagonal1[i + y] = diagonal2[i - y + N] = false;
            }
        }
        return ans;
    }
    
}