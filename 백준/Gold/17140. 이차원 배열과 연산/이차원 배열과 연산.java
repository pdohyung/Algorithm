
import java.util.*;
import java.io.*;

public class Main {

    static int r, c, k;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        board = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        while (true) {
            int rLen = board.length;
            int cLen = board[0].length;

            if (r < rLen && c < cLen && board[r][c] == k) {
                System.out.println(cnt);
                break;
            }

            if (rLen >= cLen) { // R 연산
                runR(rLen, cLen);
            } else { // C 연산
                runC(rLen, cLen);
            }

            cnt++;

            if (cnt > 100) {
                System.out.println(-1);
                break;
            }
        }
    }

    private static void runR(int rLen, int cLen) {
        List<List<Integer>> newRows = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i < rLen; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < cLen; j++) {
                int num = board[i][j];
                if (num == 0) continue;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer> newRow = makeList(map);
            newRows.add(newRow);
            maxLen = Math.max(maxLen, newRow.size());
        }

        // 배열 재생성
        maxLen = Math.min(maxLen, 100);
        board = new int[rLen][maxLen];
        for (int i = 0; i < rLen; i++) {
            List<Integer> newRow = newRows.get(i);
            for (int j = 0; j < newRow.size(); j++) board[i][j] = newRow.get(j);
        }
    }

    private static void runC(int rLen, int cLen) {
        List<List<Integer>> newColumns = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i < cLen; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < rLen; j++) {
                int num = board[j][i];
                if (num == 0) continue;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer> newColumn = makeList(map);
            newColumns.add(newColumn);
            maxLen = Math.max(maxLen, newColumn.size());
        }

        // 배열 재생성
        maxLen = Math.min(maxLen, 100);
        board = new int[maxLen][cLen];
        for (int i = 0; i < cLen; i++) {
            List<Integer> newColumn = newColumns.get(i);
            for (int j = 0; j < newColumn.size(); j++) board[j][i] = newColumn.get(j);
        }
    }

    private static List<Integer> makeList(Map<Integer, Integer> map) {
        List<int[]> pairs = new ArrayList<>();
        for (int key : map.keySet()) pairs.add(new int[]{key, map.get(key)});

        pairs.sort((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<Integer> newList = new ArrayList<>();
        for (int[] pair : pairs) {
            newList.add(pair[0]);
            newList.add(pair[1]);
        }

        return newList;
    }
}
