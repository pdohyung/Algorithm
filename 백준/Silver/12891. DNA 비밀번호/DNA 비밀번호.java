import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    static int[] myCondition;
    static int[] checkCondition;
    static int check;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int ans = 0;
        myCondition = new int[4];
        checkCondition = new int[4];
        char[] dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkCondition[i] = Integer.parseInt(st.nextToken());
            if (checkCondition[i] == 0) {
                check++;
            }
        }

        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }

        if (check == 4) {
            ans++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;
            add(dna[i]);
            remove(dna[j]);
            if (check == 4) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private void remove(char c) {
        switch (c) {
            case 'A':
                if (myCondition[0] == checkCondition[0]) {
                    check--;
                }
                myCondition[0]--;
                break;
            case 'C':
                if (myCondition[1] == checkCondition[1]) {
                    check--;
                }
                myCondition[1]--;
                break;
            case 'G':
                if (myCondition[2] == checkCondition[2]) {
                    check--;
                }
                myCondition[2]--;
                break;
            case 'T':
                if (myCondition[3] == checkCondition[3]) {
                    check--;
                }
                myCondition[3]--;
                break;
        }
    }

    private void add(char c) {
        switch (c) {
            case 'A':
                myCondition[0]++;
                if (myCondition[0] == checkCondition[0]) {
                    check++;
                }
                break;
            case 'C':
                myCondition[1]++;
                if (myCondition[1] == checkCondition[1]) {
                    check++;
                }
                break;
            case 'G':
                myCondition[2]++;
                if (myCondition[2] == checkCondition[2]) {
                    check++;
                }
                break;
            case 'T':
                myCondition[3]++;
                if (myCondition[3] == checkCondition[3]) {
                    check++;
                }
                break;
        }
    }
}