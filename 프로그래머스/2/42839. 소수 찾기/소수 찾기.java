import java.util.*;
import java.io.*;

class Solution {
    
    static HashSet<Integer> answer;
    static int N;
    static int length;
    static char[] number;
    static boolean[] visited;
    
    public int solution(String numbers) {
        answer = new HashSet<>();
        length = numbers.length();
        visited = new boolean[length];
        number = numbers.toCharArray();
        
        for(int i = 1; i <= length; i++) {
            Arrays.fill(visited, false);
            N = i;
            dfs(0, "");
        } 
        //System.out.println(answer); 
        int cnt = 0;
        for(int num : answer) {
            if (num == 1 || num == 0) {
                continue;
            }
            if(!isValid(num)) {
                continue;
            }
            //System.out.println(num);
            cnt++;
        }
        //System.out.println(answer);
        return cnt;
    }
    
    static boolean isValid(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    static void dfs(int depth, String num) {
        if (depth == N) {
            answer.add(Integer.parseInt(num));
            return;
        }
        
        for(int i = 0; i < length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, num + number[i]);
                visited[i] = false;
            }
        }
    }
    
}