import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] a = new int[10_001];
        int[] b = new int[10_001];
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        
        for (int t : topping) {
            b[t]++;
            bSet.add(t);
        }
        
        for (int t : topping) {
            b[t]--;
            a[t]++;
            aSet.add(t);
            if (b[t] == 0) bSet.remove(t);
            if (aSet.size() == bSet.size()) answer++;
        }
        
        return answer;
    }
}
