
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // n개의 트럭이 건넘, 트럭의 순서는 바꾸기 x, 무게도 같지 않다
        // 다리에는 w대의 트럭만 동시에, 하중은 L보다 작거나 같아야 함, 완전히 올라갈 때만 무게를 잼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < W; i++) q.offer(0);

        int time = 0;
        int weight = 0;
        int idx = 0;

        while (idx < N) {
            time++;
            weight -= q.poll();

            if (weight + trucks[idx] <= L) {
                q.offer(trucks[idx]);
                weight += trucks[idx];
                idx++;
            } else {
                q.offer(0);
            }
        }

        System.out.println(time + W);
    }
}
