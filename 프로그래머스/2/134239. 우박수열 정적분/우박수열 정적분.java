import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> x = new ArrayList<>();
        x.add(k);
        
        while (k != 1) {            
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = (k * 3) + 1;
            }
            
            x.add(k);
        }
        
        List<Double> w = new ArrayList<>();
        for (int i = 0; i < x.size() - 1; i++) {
            int now = x.get(i);
            int next = x.get(i + 1);
            double r = Math.min(now, next) + (Math.abs(next - now) / 2.0);
            w.add(r);
        }
        
        List<Double> result = new ArrayList<>();
        for (int[] range : ranges) {
            int a = range[0];
            int b = w.size() + range[1];
            double sum = 0;
            
            if (a < b) {
                for (int i = a; i < b; i++) {
                    sum += w.get(i);
                }
            } else if (a > b) {
                sum = -1;
            } else {
                sum = 0;
            }
            
            result.add(sum);
        }
        
        double[] answer = new double[result.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = result.get(i);
        return answer;
    }
}
