import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] Dungeons;
    static boolean[] visit;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        visit = new boolean[Dungeons.length];
        answer = 0;
        find(k, 0);
        return answer;
    }
    
    static void find(int k, int cnt) {
        for(int i = 0; i < Dungeons.length; i++) {
            if(!visit[i] && k >= Dungeons[i][0]) {
                visit[i] = true;
                find(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visit[i] = false;
            }
        }
    }
}