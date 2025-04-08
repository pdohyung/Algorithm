import java.util.*;

class Solution {
    
    List<String> list;
    int depth, colLen, rowLen;
    boolean[] visited;
    
    public int solution(String[][] relation) {
        rowLen = relation.length;
        colLen = relation[0].length;
        list = new ArrayList<>();
        
        for (int i = 1; i <= colLen; i++) {
            visited = new boolean[colLen];
            depth = i;
            dfs("", 0);
        }
        
        List<String> result = new ArrayList<>();
        List<String> next = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            String now = list.get(i);
            
            // 최소성 만족 못하면 pass
            if (next.contains(now)) continue;
        
            // 데이터 조합 만들기
            Set<String> set = new HashSet<>();
            for (int j = 0; j < rowLen; j++) {
                String s = "";
                for (int k = 0; k < now.length(); k++) {
                    s += " " + relation[j][now.charAt(k) - '0'];
                }
                set.add(s);
            }
            
            // 사이즈가 행과 동일하면 후보키 가능
            if (set.size() == rowLen) {
                result.add(now);
                
                // 최소성을 만족 못하는 경우 저장
                for (int j = 0; j < list.size(); j++) {
                    String s = list.get(j);
                    if (next.contains(s)) continue;
                    if (s.equals(now)) continue;
                    
                    List<Character> keys = new ArrayList<>();
                    for (char c : now.toCharArray()) keys.add(c);
                    
                    int cnt = 0;
                    for (char c : s.toCharArray()) if (keys.contains(c)) cnt++;
                    if (cnt == keys.size()) next.add(s);
                }
            }
        }
        
        return result.size();
    }
    
    // 릴레이션 조합 구하기
    private void dfs(String now, int idx) {
        if (depth == now.length()) {
            list.add(now);
            return;
        }
        
        for (int i = idx; i < colLen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(now + i, i);
                visited[i] = false;
            }
        }
    }
}
