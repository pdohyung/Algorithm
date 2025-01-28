
import java.util.*;
import java.io.*;

class Node {
    int num;
    int dir;

    public Node(int num, int dir) {
        this.num = num;
        this.dir = dir;
    }
}

public class Main {

    static ArrayList<Character>[] wheels;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new ArrayList[5];
        graph = new ArrayList[5];

        for (int i = 1; i <= 4; i++) {
            char[] info = br.readLine().toCharArray();
            wheels[i] = new ArrayList<>();
            graph[i] = new ArrayList<>();

            for (char c : info) {
                wheels[i].add(c);
            }
        }

        graph[1].add(2);
        graph[2].add(3);
        graph[2].add(1);
        graph[3].add(4);
        graph[3].add(2);
        graph[4].add(3);

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[5];

            ArrayList<Node> result = bfs(new Node(wheelNum, dir));

//            for (int i = 0; i < 4; i++) {
//                System.out.println(wheels[i + 1]);
//            }
//            System.out.println();

            for (Node node : result) {
                int nowNum = node.num;
                int nowDir = node.dir;

                if (nowDir == 1) {
                    swap(nowNum);
                } else {
                    swapReverse(nowNum);
                }
            }


        }

        int answer = 0;

        for (int i = 0; i < 4; i++) {
//            System.out.println(wheels[i + 1]);
            Character c = wheels[i + 1].get(0);

            if (c == '0') continue;

            answer += (int) Math.pow(2, i);
        }

        System.out.println(answer);
    }

    private static ArrayList<Node> bfs(Node start) {
        ArrayList<Node> result = new ArrayList<>();
        ArrayDeque<Node> q = new ArrayDeque<>();

        result.add(start);
        q.add(start);
        visited[start.num] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int wheelNum = now.num;
            int dir = now.dir;

            for (int next : graph[wheelNum]) {

                if (visited[next]) continue;
                if (!isValid(wheelNum, next)) continue;

                visited[next] = true;
                q.add(new Node(next, dir * -1));
                result.add(new Node(next, dir * -1));
            }
        }
//        System.out.println(result);
        return result;
    }

    private static boolean isValid(int now, int next) {
        if (now == 1 || (now == 2 && next == 3) || (now == 3 && next == 4)) {
            return wheels[now].get(2) != wheels[next].get(6);
        } else {
            return wheels[now].get(6) != wheels[next].get(2);
        }
    }

    private static void swap(int wheelNum) {
        char eChar = wheels[wheelNum].remove(7);
        wheels[wheelNum].add(0, eChar);
    }

    private static void swapReverse(int wheelNum) {
        char sChar = wheels[wheelNum].remove(0);
        wheels[wheelNum].add(sChar);
    }
}
