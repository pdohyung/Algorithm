import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        int[] res = new int[M];
        Arrays.sort(arr1);

        for(int i = 0; i < M; i++){
            res[i] = binarySearch(arr1, arr2[i]);
        }

        for(int i = 0; i < M; i++){
            System.out.println(res[i]);
        }
    }

    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length;

        while(end > start){
            int mid = (start + end) / 2;
            int val = arr[mid];

            if(target == val)
                return 1;
            else if(target > val)
                start = mid + 1;
            else
                end = mid;
        }
        return 0;
    }
}