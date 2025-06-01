import java.util.*;

class Solution {
    
    char[] A;
    List<String> result;
    
    public int solution(String word) {
        A = new char[] {'A', 'E', 'I', 'O', 'U'};
        result = new ArrayList<>();
        
        dfs(0, "");
        
        Collections.sort(result);
        
        int answer = 0;
        
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    void dfs(int depth, String word) {
        result.add(word);
        
        if (depth == 5) return;
        
        for (char a : A) {
            dfs(depth + 1, word + a);
        }
    }
}
