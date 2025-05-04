import java.util.*;
import java.io.*;

class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Meeting m : meetings) {
            if (!pq.isEmpty() && pq.peek() <= m.start) {
                pq.poll();
            }

            pq.offer(m.end);
        }

        System.out.println(pq.size());
    }
}
