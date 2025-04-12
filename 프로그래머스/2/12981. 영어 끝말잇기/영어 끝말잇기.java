import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int[] people = new int[n];
        String now = words[0];
        char last = now.charAt(now.length() - 1);
        Set<String> set = new HashSet<>();
        set.add(now);
        
        for (int i = 1; i < words.length; i++) {
            now = words[i];
            
            if (now.length() == 1 || set.contains(now) || now.charAt(0) != last) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            set.add(now);
            last = now.charAt(now.length() - 1);
        }
        
        return answer;
    }
}
