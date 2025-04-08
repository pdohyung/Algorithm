import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        Queue<Character> q = new ArrayDeque<>();
        for (char c : skill.toCharArray()) q.add(c);
        
        for (String s : skill_trees) {
            StringBuilder tree = new StringBuilder();
            Queue<Character> sk = new ArrayDeque<>(q);
            
            for (int i = 0; i < s.length(); i++) {
                if (skill.contains(String.valueOf(s.charAt(i)))) tree.append(s.charAt(i));
            }
            
            for (int i = 0; i < tree.length(); i++) {
                char now = sk.poll();
                if (now != tree.charAt(i)) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}
