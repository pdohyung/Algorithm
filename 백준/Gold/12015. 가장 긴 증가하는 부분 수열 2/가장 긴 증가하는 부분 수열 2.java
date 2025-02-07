import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> lis;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            if (lis.isEmpty() || A[i] > lis.get(lis.size() - 1)) {
                lis.add(A[i]);
            } else {
                int pos = bs(A[i]);
                lis.set(pos, A[i]);
            }
        }

        System.out.println(lis.size());
    }

    private static int bs(int target) {
        int start = 0;
        int end = lis.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (lis.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
