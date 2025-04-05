import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int s = 0;
        int e = people.length - 1;
        int answer = 0;
        
        while (s <= e) {
            if (s == e) {
                if (people[s] <= limit) answer++;
                break;
            } else {
                if (people[s] + people[e] <= limit) {
                    s++;
                    e--;
                } else e--;
                
                answer++;
            }
        }
        
        return answer;
    }
}