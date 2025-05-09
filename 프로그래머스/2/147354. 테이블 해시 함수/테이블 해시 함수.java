import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        
        list.sort((a, b) -> {
            if (a[col - 1] != b[col - 1]) return a[col - 1] - b[col - 1];
            return b[0] - a[0];
        });
        
        int answer = 0;
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int result = 0;
            
            for (int v : list.get(i)) {
                result += v % (i + 1);
            }
            
            answer = answer ^ result;
        }
        
        return answer;
    }
}
