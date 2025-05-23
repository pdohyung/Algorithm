import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        int cnt = 0;
        
        while (start <= end) {
            if (people[start] + people[end] > limit) {
                cnt++;
                end--;
            } else {
                cnt++;
                start++;
                end--;
            }
        }
        
        return cnt;
    }
}
