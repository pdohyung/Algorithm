import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        leftMax[0] = height[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[W];
        rightMax[W - 1] = height[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMax));

        int answer = 0;
        for (int i = 0; i < W; i++) {
            int w = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (w > 0) answer += w;
        }

        System.out.println(answer);
    }
}
