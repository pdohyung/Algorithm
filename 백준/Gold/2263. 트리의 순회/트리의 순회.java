import java.io.*;
import java.util.*;

public class Main {

    private static int[] inOrder, postOrder, idx;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        idx = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            idx[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        answer = new StringBuilder();
        preOrder(0, n - 1, 0, n - 1);
        System.out.println(answer.toString());
    }

    private static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postOrder[postEnd];
        int rootIdx = idx[root];
        answer.append(root).append(" ");

        int leftSize = rootIdx - inStart;

        preOrder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);
        preOrder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
