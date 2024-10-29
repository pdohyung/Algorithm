import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 소요 시간 기준 최소 힙
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int currentTime = 0;
        int totalWaitTime = 0;
        int index = 0;
        int count = jobs.length;

        while (index < count || !pq.isEmpty()) {
            // 현재 시간까지 요청된 작업을 모두 큐에 추가
            while (index < count && jobs[index][0] <= currentTime) {
                pq.add(jobs[index]);
                index++;
            }

            if (pq.isEmpty()) {
                // 현재 시간까지 요청된 작업이 없으면, 다음 요청 시간으로 이동
                currentTime = jobs[index][0];
            } else {
                // 소요 시간이 가장 짧은 작업부터 처리
                int[] job = pq.poll();
                currentTime += job[1];
                totalWaitTime += (currentTime - job[0]); // 대기 시간: 종료 시간 - 요청 시간
            }
        }

        // 평균 대기 시간 반환
        return totalWaitTime / count;
    }
}
