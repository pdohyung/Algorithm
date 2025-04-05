import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int length = sizes.length;
        
        for (int i = 0; i < length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        
        int w = 0;
        int h = 0;
        
        for (int i = 0; i < length; i++) {
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        
        return w * h;
    }
}
