import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> aList = new ArrayList<>();
        for (int a : A) aList.add(a);
        
        int answer = 0;
        
        for (int b : B) {
            int start = 0;
            int end = aList.size() - 1;
            
            while (start <= end) {
                int mid = (start + end) / 2;
                
                if (aList.get(mid) >= b) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            if (start > 0) {
                answer++;
                aList.remove(start - 1);
            }     
        }
        
        return answer;
    }
}
