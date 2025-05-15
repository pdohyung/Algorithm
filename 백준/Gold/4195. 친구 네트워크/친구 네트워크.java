
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 친구 관계 수 F가 주어지고, 각 관계가 진행될 때마다 두 친구의 네트워크 친구 수 찾기
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            String[] lines = new String[F];

            for (int i = 0; i < F; i++) {
                lines[i] = br.readLine();
            }

            Map<String, Integer> friends = new HashMap<>();
            int idx = 0;

            for (int i = 0; i < F; i++) {
                String[] names = lines[i].split(" ");

                for (int j = 0; j < 2; j++) {
                    if (!friends.containsKey(names[j])) {
                        friends.put(names[j], idx++);
                    }
                }
            }

            int[] size = new int[friends.size()];
            Arrays.fill(size, 1);
            parent = new int[friends.size()];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < F; i++) {
                String[] names = lines[i].split(" ");

                int f1 = friends.get(names[0]);
                int f2 = friends.get(names[1]);
                int x = find(f1);
                int y = find(f2);

                if (x != y) {
                    size[x] += size[y];
                    size[y] = 0;
                    union(f1, f2);
                }

                answer.append(size[x]).append("\n");
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int rX = find(x);
        int rY = find(y);
        if (rX != rY) parent[rY] = rX;
    }
}
