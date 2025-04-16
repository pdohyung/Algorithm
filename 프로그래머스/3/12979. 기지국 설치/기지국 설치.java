class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int before = 0;
        int W = (w * 2) + 1;
        
        for (int station : stations) {
            int start = station - w;
            int end = station + w;
            
            if (start <= before) {
                before = end;
                continue;
            }
            
            int now = start - before - 1;
            answer += now / W;
            if (now % W != 0) answer++;
            
            before = end;
        }

        if (before < n) {
            int now = n - before;
            answer += now / W;
            if (now % W != 0) answer++;
        }
        
        return answer;
    }
}
