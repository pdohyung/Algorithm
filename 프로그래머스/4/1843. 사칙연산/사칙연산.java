import java.util.*;

class Solution {
    
    int[] N;
    char[] O;
    int[][] max, min;
    
    public int solution(String arr[]) {
        int size = arr.length;
        N = new int[(size / 2) + 1];
        O = new char[size / 2];
        
        // 숫자, 연산자 분리
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) N[i / 2] = Integer.parseInt(arr[i]);
            else O[i / 2] = arr[i].charAt(0);
        }
        
        // 최소, 최대 배열 초기화
        min = new int[size][size];
        max = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        
        int len = N.length;
        
        for (int d = 0; d < len; d++) {
            for (int i = 0; i < len - d; i++) {
                int j = i + d;
                
                if (i == j) {
                    min[i][j] = max[i][j] = N[i];
                    continue;
                }
                
                // 연산자의 총 개수는 숫자보다 1개 적으므로 j는 제외
                for (int k = i; k < j; k++) {
                    if (O[k] == '+') {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                    } else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }
        
        return max[0][len - 1];
    }
}
