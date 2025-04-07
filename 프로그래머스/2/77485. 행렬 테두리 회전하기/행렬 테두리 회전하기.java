import java.util.*;

class Solution {
    
    int[][] map;
    int min;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows + 1][columns + 1];
        int cnt = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = ++cnt;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int q = 0; q < queries.length; q++) {
            int[] query = queries[q];
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            min = map[x1][y1];
            
            for (int i = x1; i < x2; i++) swap(i, y1, i + 1, y1);
            for (int j = y1; j < y2; j++) swap(x2, j, x2, j + 1);
            for (int i = x2; i > x1; i--) swap(i, y2, i - 1, y2);
            for (int j = y2; j > y1 + 1; j--) swap(x1, j, x1, j - 1);

            result.add(min);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = result.get(i);
        return answer;
    }
    
    void swap(int x1, int y1, int x2, int y2) {
        min = Math.min(min, map[x2][y2]); 
        
        int temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }
}
