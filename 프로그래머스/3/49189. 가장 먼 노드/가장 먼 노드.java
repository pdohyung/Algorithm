import java.util.*;
import java.io.*;

class Node {
    int point;
    int cnt;
    
    Node(int point, int cnt) {
        this.point = point;
        this.cnt = cnt;
    }
    
    int getPoint() {
        return this.point;
    }
    
    int getCnt() {
        return this.cnt;
    }
}


class Solution {
    
    public ArrayList<Integer>[] graph;
    public int[] result;
    public boolean[] visited;
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
        
        visited = new boolean[n + 1];
        result = new int[n + 1];
        answer = 0;
        
        // bfs 수행
        bfs(1);
        
        // System.out.println(Arrays.toString(result));
        // 최댓값을 구해서 결과 리턴

        int max = Integer.MIN_VALUE;
        
        for(int val : result) {
            max = Math.max(max, val);
        }
        
        for(int val : result) {
            if(val == max) answer++;
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(start, 0));
        visited[start] = true;
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int cnt = now.getCnt() + 1;
            
            for(int next : graph[now.getPoint()]) {
                if(!visited[next]) {
                    result[next] = cnt;
                    visited[next] = true;
                    q.add(new Node(next, cnt));
                }
            }
        }
    }
}