import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int N = line.length;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        Set<String> points = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];
                
                long A = line1[0];
                long B = line1[1];
                long E = line1[2];
                
                long C = line2[0];
                long D = line2[1];
                long F = line2[2];
                
                long mod = A * D - B * C;
                if (mod == 0) continue;
                
                long X = B * F - E * D;
                long Y = E * C - A * F;
                if (X % mod != 0 || Y % mod != 0) continue;
                
                int x = (int) (X / mod);
                int y = (int) (Y / mod);

                points.add(x + "," + y);
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                
            }
        }
        
        List<String> result = new ArrayList<>(); 
        
        for (int y = maxY; y >= minY; y--) {
            StringBuilder sb = new StringBuilder();
            
            for (int x = minX; x <= maxX; x++) {
                if (points.contains(x + "," + y)) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            
            result.add(sb.toString());
        }
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
