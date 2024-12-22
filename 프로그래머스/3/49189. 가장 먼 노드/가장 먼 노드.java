import java.util.*;
import java.io.*;

class Solution {
    
    public ArrayList<Integer>[] graph;
    public int[] distance;
    public int answer;
    
    public int solution(int n, int[][] edge) {
        // 그래프를 저장
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] node : edge) {
            graph[node[0]].add(node[1]);
            graph[node[1]].add(node[0]);
        }
        
        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        // bfs 수행
        bfs(1);
        
        // 최댓값을 구해서 결과 리턴
        int max = Integer.MIN_VALUE;
    
        for(int d : distance) {
            if (d > max) {
                max = d;
                answer = 1;
            } else if (max == d){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        distance[start] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : graph[now]) {
                if(distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}