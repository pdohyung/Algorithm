
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static LinkedList<Integer>[][] trees;
    static int[][] map, A;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        map = new int[N][N];
        trees = new LinkedList[N][N];
        
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) trees[i][j] = new LinkedList<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) map[i][j] = 5;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[r][c].add(age);
        }

        // 입력 시 같은 위치에 여러 나무가 들어올 수 있으므로, 나이순으로 정렬
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Collections.sort(trees[i][j]);

        for (int k = 0; k < K; k++) {
            // 봄 + 여름, 나무에 양분을 주고, 죽은 나무에 대한 양분을 추가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    LinkedList<Integer> nowTrees = trees[i][j];
                    LinkedList<Integer> newTrees = new LinkedList<>();
                    int deadCnt = 0;
                    while (!nowTrees.isEmpty()) {
                        int age = nowTrees.pollFirst();
                        if (map[i][j] >= age) {
                            map[i][j] -= age;
                            newTrees.add(age + 1);
                        } else deadCnt += age / 2;
                    }
                    trees[i][j] = newTrees;
                    map[i][j] += deadCnt;
                }
            }

            // 가을, 나무 번식
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    List<Integer> nowTrees = trees[i][j];
                    for (int now : nowTrees) {
                        if (now % 5 != 0) continue;
                        for (int l = 0; l < 8; l++) {
                            int nx = i + dx[l];
                            int ny = j + dy[l];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                            trees[nx][ny].addFirst(1);
                        }
                    }
                }
            }

            // 겨울, 양분 추가
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) map[i][j] += A[i][j];
        }

        // 살아있는 나무 개수 출력
        int aliveTrees = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) aliveTrees += trees[i][j].size();

        System.out.println(aliveTrees);
    }
}
