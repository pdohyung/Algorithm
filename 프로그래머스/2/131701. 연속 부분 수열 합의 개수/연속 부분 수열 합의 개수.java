import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int N = elements.length;
        Set<Integer> set = new HashSet<>();
        int[] nelements = new int[N * 2];
        
        for (int i = 0; i < N; i++) {
            nelements[i] = elements[i];
            nelements[i + N] = elements[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += nelements[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}