import java.util.*;

class Solution {
    public int solution(int[] a) {
        // 풍선이 n개 나열되어있고, 서로 다른 숫자가 써져있음, 1개만 남을 때까지 터트림
        // 임의의 인접한 두 풍선을 고름, 하나를 터트림
        // 풍선들 사이에 빈공간이 생기면 중앙으로 밀착시킴
        // 인접한 두 풍선 중 번호가 더 작은 풍선을 터트리는 행위는 최대 1번만 가능
        // 최후까지 남지 못하는 풍선도 존재할 것임, 최후까지 남기는 것이 가능한 풍선의 개수를 return
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        
        left[0] = a[0];
        
        for (int i = 1; i < len; i++) {
            left[i] = Math.min(a[i], left[i - 1]);
        }
        
        right[len - 1] = a[len - 1];
        
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.min(a[i], right[i + 1]);
        }
        
        
        int answer = len;
        
        for (int i = 0; i < len; i++) {
            if (a[i] > left[i] && a[i] > right[i]) {
                answer--;
            }
        }
        
        return answer;
    }
}
