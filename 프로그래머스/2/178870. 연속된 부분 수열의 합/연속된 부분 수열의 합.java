import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0, sum = 0, size = sequence.length;
        
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while (right < sequence.length && sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k) {
                if (size > right - left) {
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
}