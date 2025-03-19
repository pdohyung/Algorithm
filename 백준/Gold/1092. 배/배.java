import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> crane = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) crane.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int day = 0;

        while (!box.isEmpty()) {
            int craneIdx = 0, boxIdx = 0;

            while (true) {
//                System.out.println(crane);
//                System.out.println(box);
//                System.out.println();
                if (boxIdx >= box.size() || craneIdx >= N) break;
                if (crane.get(craneIdx) >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }
            day++;
        }

        System.out.println(day);
    }
}
