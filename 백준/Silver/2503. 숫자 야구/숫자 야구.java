import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] num = new String[101];
        int[] strike = new int[101];
        int[] ball = new int[101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 123; i <= 987; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (isDuplicate(String.valueOf(i)) || !isValid(num[j], String.valueOf(i), strike[j], ball[j])) {
                    flag = false;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isDuplicate(String num) {
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (char c : num.toCharArray()) {
            list.add(c);
            set.add(c);
        }
        if (list.size() != set.size()) {
            return true;
        }
        return false;
    }

    private static boolean isValid(String number, String idx, int strike, int ball) {
        if (idx.contains("0")){
            return false;
        }
        int expectedStrike = 0;
        int expectedBall = 0;
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) == idx.charAt(i)) {
                expectedStrike++;
                continue;
            }
            if (number.contains(String.valueOf(idx.charAt(i)))) {
                expectedBall++;
            }
        }

        if (expectedStrike == strike && expectedBall == ball) {
            return true;
        }
        return false;
    }
}