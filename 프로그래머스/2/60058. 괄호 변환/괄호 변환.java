import java.util.*;
import java.io.*;

class Solution {
    
    private static String u;
    private static String v;
    private static String answer;
    
    public String solution(String p) {
        return dfs(p);
    }
    
    private static String dfs(String p) {
        
        if (p.isEmpty()) {
            return p;
        }
        
        int left = 0;
        int right = 0;
        int idx = 0;
        
        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                idx = i;
                break;
            }
        }
        
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        
        //System.out.println(u + " " + v);
        
        if (isCorrect(u)) {
            return u + dfs(v);
        }
        
        return "(" + dfs(v) + ")" + reverse(u);
    }
    
    private static boolean isCorrect(String u) {
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for (Character c : u.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return true;
    }
    
    private static String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        
        return sb.toString();
    }

}