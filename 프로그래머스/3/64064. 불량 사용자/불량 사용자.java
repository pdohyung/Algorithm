import java.util.*;

class Solution {
    
    ArrayList<Integer>[] list;
    boolean[] visited;
    List<Integer> idx;
    Set<String> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        int listLen = banned_id.length;
        list = new ArrayList[listLen];
        for (int i = 0; i < listLen; i++) list[i] = new ArrayList<>();
        
        // 제제 아이디 패턴에 해당하는 유저 아이디 추가
        for (int i = 0; i < listLen; i++) {
            char[] banned = banned_id[i].toCharArray();
            
            for (int j = 0; j < user_id.length; j++) {
                StringBuilder sb = new StringBuilder();
                char[] user = user_id[j].toCharArray();
                if (banned.length != user.length) continue;
                
                for (int k = 0; k < user.length; k++) {
                    if (banned[k] == user[k] || banned[k] == '*') sb.append(banned[k]);
                    else break;
                }
                    
                if (sb.toString().equals(banned_id[i])) list[i].add(j);
            }
        }
        
        // 백트래킹
        result = new HashSet();
        visited = new boolean[user_id.length];
        idx = new ArrayList<>();
        for (int i = 0; i < listLen; i++) {
            if (!list[i].isEmpty()) idx.add(i);
        }
        dfs(0, 0, new ArrayList<>());
        
        return result.size();
    }
    
    void dfs(int depth, int i, ArrayList<Integer> path) {
        if (depth == idx.size()) {
            ArrayList<Integer> sorted = new ArrayList<>(path);
            Collections.sort(sorted);
            result.add(sorted.toString());
            return;
        }
        
        for (int user : list[idx.get(i)]) {
            if (!visited[user]) {
                visited[user] = true;
                path.add(user);
                dfs (depth + 1, i + 1, path);
                path.remove(path.size() - 1);
                visited[user] = false;
            }
        }
    }
}
