import java.io.*;
import java.util.*;

class Solution {
    
    private static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] adjList;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        adjList = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // 정답 개수를 구할 때, 0과 1 인덱스는 제외

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.dest] < now.cost) continue;

            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for (int d : dist) {
            if (d <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}