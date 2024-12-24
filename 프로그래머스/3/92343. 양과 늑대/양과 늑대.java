import java.util.*;

class Solution {

    public ArrayList<Integer>[] graph;
    public int answer;
    public int[] infoz;

    public int solution(int[] info, int[][] edges) {
        infoz = info;

        // 그래프 초기화
        int length = info.length;
        graph = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end); // 단방향
        }

        answer = 0;

        // 초기 상태에서 0번 노드만 방문 가능
        ArrayList<Integer> startNodes = new ArrayList<>();
        startNodes.add(0);

        // DFS 탐색 시작
        dfs(startNodes, 0, 0, 0);

        return answer;
    }

    public void dfs(List<Integer> nodes, int current, int sheep, int wolf) {
        // 현재 노드가 늑대인지 양인지 확인
        if (infoz[current] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        // 늑대가 양 이상이 되면 종료
        if (wolf >= sheep) {
            return;
        }

        // 최대 양 갱신
        answer = Math.max(answer, sheep);

        // 현재 탐색 가능한 노드 리스트를 순회
        List<Integer> newNodes = new ArrayList<>(nodes);
        newNodes.remove((Integer) current); // 현재 노드 제거
        newNodes.addAll(graph[current]); // 현재 노드의 자식 추가

        for (int next : newNodes) {
            dfs(newNodes, next, sheep, wolf);
        }
    }
}