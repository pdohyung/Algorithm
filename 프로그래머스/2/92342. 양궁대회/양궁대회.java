import java.io.*;
import java.util.*;

class Solution {
    
    static int[] Info;
    static int[] answer;
    static int max;
    
    public int[] solution(int n, int[] info) {
        Info = info;
        max = 0;
        dfs(n, 0, new int[11]);
        
        return max > 0 ? answer : new int[] {-1};
    }
    
    static void calc(int[] scoreInfo) {
        int score = 0;
        
        for(int i = 0; i <= 10; i++) {
            if(Info[i] + scoreInfo[i] > 0) {
                score += scoreInfo[i] > Info[i] ? (10 - i) : -(10 - i);
            }
        }
        
        if(score > max) {
            max = score;
            answer = scoreInfo.clone();
        } else if (max > 0 && score == max) {
            for(int i = 10; i >= 0; i--) {
                if(scoreInfo[i] > answer[i]) {
                    answer = scoreInfo.clone();
                    break;
                } else if(scoreInfo[i] < answer[i]){
                    break;
                }
            }
        }
    }
    
    static void dfs(int n, int idx, int[] scoreInfo) {
        if(n == 0) {
            calc(scoreInfo);
            return;
        }
        
        for(int i = idx; i <= 10; i++) {
            int cnt = Math.min(n, Info[i] + 1);
            scoreInfo[i] = cnt;
            dfs(n - cnt, i + 1, scoreInfo);
            scoreInfo[i] = 0;
        }
    }
   
}