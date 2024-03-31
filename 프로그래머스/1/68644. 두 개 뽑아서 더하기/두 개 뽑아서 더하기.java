import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> distinctNum = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                distinctNum.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = distinctNum.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        Arrays.sort(answer);
    
        return answer;
    }
}