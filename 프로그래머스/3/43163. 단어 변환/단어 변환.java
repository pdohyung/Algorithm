import java.util.*;

class Word {
    String w;
    int cnt;
    
    Word (String w, int cnt) {
        this.w = w;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 한 번에 한 개의 알파벳만 바꿀 수 있고, words에 있는 단어로만 변환이 가능함
        int answer = 0;
        int N = words.length;
        boolean[] visited = new boolean[N];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word now = q.poll();
            String w = now.w;
            int cnt = now.cnt;
            
            if (w.equals(target)) {
                answer = cnt;
                break;
            }
            
            for (int i = 0; i < N; i++) {
                if (!visited[i] && isValid(w, words[i])) {
                    visited[i] = true;
                    q.offer(new Word(words[i], cnt + 1));
                }
            }
        }

        return answer;
    }
    
    boolean isValid(String s1, String s2) {
        int cnt = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        
        if (cnt == 1) return true;
        
        return false;
    }
}
