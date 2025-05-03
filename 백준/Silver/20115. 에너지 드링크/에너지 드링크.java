import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] drinks = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) drinks[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(drinks);

        double result = drinks[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            result += drinks[i] / 2;
        }

        System.out.println(result);
    }
}
