import java.util.*;

class Solution {
    
    List<Character> types;
    List<List<Character>> comb;
    boolean[] visited;
    
    public long solution(String expression) {
        types = new ArrayList<>();
        char[] chars = expression.toCharArray();
        for (char c : chars)
            if (!types.contains(c) && (c == '*' || c == '+' || c == '-')) types.add(c);
        
        List<Character> opers = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (char c : chars) {
            if (types.contains(c)) {
                opers.add(c);
                numbers.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
            } else num.append(c);
        }
        numbers.add(Long.parseLong(num.toString()));
        
        // 수식 우선순위 경우의 수 구하기
        comb = new ArrayList<>();
        visited = new boolean[types.size()];
        dfs(0, new ArrayList<>());
        
        long answer = 0;
        long sum = 0;
        
        for (int i = 0; i < comb.size(); i++) {
            List<Character> now = comb.get(i);
            List<Character> nowOpers = new ArrayList<>(opers);
            List<Long> nowNumbers = new ArrayList<>(numbers);
                
            for (int j = 0; j < now.size(); j++) {
                char oper = now.get(j);
                
                while (nowOpers.contains(oper)) {
                    
                    for (int k = 0; k < nowOpers.size(); k++) {
                        char nowOper = nowOpers.get(k);
                        
                        if (nowOper == oper) {
                            long s = cal(nowOper, nowNumbers.get(k), nowNumbers.get(k + 1));
                            nowNumbers.set(k, s);
                            nowOpers.remove(k);
                            nowNumbers.remove(k + 1);
                            break;
                        }
                    }
                    
                }
            }
            
            answer = Math.max(Math.abs(nowNumbers.get(0)), answer);
        }
        
        return answer;
    }
    
    public long cal (char oper, long n1, long n2) {
        switch (oper) {
            case '*':
                return n1 * n2;
            case '+' :
                return n1 + n2;
            case '-' :
                return n1 - n2;
        }
        return 1;
    }
    
    public void dfs(int depth, List<Character> now) {
        if (depth == types.size()) {
            comb.add(now);
            return;
        }
        
        for (int i = 0; i < types.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<Character> next = new ArrayList<Character>(now);
                next.add(types.get(i));
                dfs(depth + 1, next);
                visited[i] = false;
            }
        }
    }
}
