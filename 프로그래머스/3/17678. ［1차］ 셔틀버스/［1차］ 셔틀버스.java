import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 크루들의 도착 시간을 숫자로 변환하여 pq에 저장
        // 셔틀 운행을 반복하여 가장 늦게 탈 수 있는 시간을 갱신
        // 반복이 끝나고 마지막 셔틀이 비었다면 마지막 셔틀의 출발 시간으로 갱신
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String tt : timetable) {
            String[] info = tt.split(":");
            int H = Integer.parseInt(info[0]);
            int M = Integer.parseInt(info[1]);
            pq.offer(H * 60 + M);
        }
        
        int start = 540;
        int me = 0;
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            cnt = 0;
            
            while (!pq.isEmpty()) {
                int now = pq.peek();
                
                if (cnt < m && pq.peek() <= start) {
                    pq.poll();
                    cnt++;
                } else break;
                
                me = now - 1;
            }
            
            start += t;
        }
        
        if (cnt < m) {
            me = start - t;
        }
        
        StringBuilder answer = new StringBuilder();
        
        int H = me / 60;
        int M = me % 60;
        
        if (H < 10) answer.append("0");
        answer.append(H);
        
        answer.append(":");
        
        if (M < 10) answer.append("0");
        answer.append(M);
        
        return answer.toString();
    }
}
