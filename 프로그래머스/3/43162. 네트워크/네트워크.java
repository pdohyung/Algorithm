import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] adjList;
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        adjList = new ArrayList[n];
        visit = new boolean[n];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            int[] edge = computers[i];
            for (int j = 0; j < edge.length; j++) {
                if (i == j) continue;

                if (edge[j] == 1) {
                    adjList[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    private static void dfs(int now) {
        visit[now] = true;

        for (int next : adjList[now]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}