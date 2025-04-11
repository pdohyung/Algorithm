import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int before = arr[0];
        
        for (int i = 1; i < len; i++) {
            int max = Math.max(before, arr[i]);
            
            while (true) {
                if (max % before == 0 && max % arr[i] == 0) {
                    before = max;
                    break;
                }
                max++;
            }
        }
        
        return before;
    }
}
