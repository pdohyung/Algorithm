import java.util.*;

class Solution {
    
    String[][] ttickets;
    boolean[] used;
    List<String> result;
    
    public String[] solution(String[][] tickets) {
        ttickets = tickets;
        Arrays.sort(ttickets, (a, b) -> a[1].compareTo(b[1]));
        
        used = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs(0, "ICN", "ICN");
        
        String[] answer = result.get(0).split(" ");
        return answer;
    }
    
    private void dfs(int depth, String now, String path) {
        if (depth == ttickets.length) {
            result.add(path);
            return;
        }
        
        for (int i = 0; i < ttickets.length; i++) {
            if (!used[i] && ttickets[i][0].equals(now)) {
                String next = ttickets[i][1];
                used[i] = true;
                dfs(depth + 1, next, path + " " + next);
                used[i] = false;
            }
        }
    }
}
