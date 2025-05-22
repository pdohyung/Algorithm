import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착, 하나의 셔틀에는 최대 m명의 승객이 탐
        // 도착한 순간까지 대기열에 선 크루원들을 최대 인원까지 태움
        // 콘은 게으르기 때문에 같은 시각에 도착해도 대기열 가장 뒤에 섬
        // 모든 크루는 23:59가 되면 집으로 가고, 다음날 셔틀을 타는 일은 없음
        // 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시간 중 제일 늦은 시각을 구해라.
        
        // 시간 입력을 숫자로 변환
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String tt : timetable) {
            String[] s = tt.split(":");
            int v = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            pq.offer(v);
        }
        
        int now = 540;
        
        // 마지막 버스를 제외하고 처리
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (!pq.isEmpty() && pq.peek() <= now) {
                    pq.poll();
                }
            }
            
            now += t;
        }
        
        int before = now;
        int cnt = 0;
        int result = 0;
        
        // 마지막 버스 처리
        for (int j = 0; j < m - 1; j++) {
            if (!pq.isEmpty() && pq.peek() <= now) {
                before = pq.poll();
                cnt++;
            }
        }
        
        // 대기열이 비었거나 대상자가 없으면 셔틀 도착시간으로 갱신
        if (pq.isEmpty() || pq.peek() > now) {
            result = now;
        } else {
            if (before > pq.peek()) {
                result = pq.poll() - 1;
            } else if (before == pq.peek()) {
                result = before - 1;
            } else {
                result = before;
            }
        }
        
        // 정답 문자열 생성
        StringBuilder answer = new StringBuilder();
        int H = result / 60;
        int M = result % 60;
        
        if (H / 10 > 0) answer.append(H);
        else answer.append("0").append(H);
        
        answer.append(":");
        
        if (M / 10 > 0) answer.append(M);
        else answer.append("0").append(M);
        
        return answer.toString();
    }
}
