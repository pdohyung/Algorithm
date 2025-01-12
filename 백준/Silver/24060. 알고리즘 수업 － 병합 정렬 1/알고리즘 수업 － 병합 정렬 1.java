import java.io.*;
import java.util.*;

public class Main {

    static int[] arr, tmp;
    static int N, K, cnt, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = -1;
        cnt = 0;

        arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(arr, 0, N - 1);

        System.out.println(answer);
    }

    private static void sort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(A, left, mid);
            sort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    private static void merge(int[] A, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right) {
            if (A[i] < A[j]) {
                tmp[idx] = A[i++];
            } else {
                tmp[idx] = A[j++];
            }
            idx++;
        }

        // 나머지 채우기
        while (i <= mid) {
            tmp[idx++] = A[i++];
        }

        while (j <= right) {
            tmp[idx++] = A[j++];
        }

        i = left;
        idx = 0;

        while (i <= right) {
            arr[i] = tmp[idx];
            cnt++;

            if (cnt == K) {
                answer = tmp[idx];
                break;
            }

            i++;
            idx++;
        }
    }
}
