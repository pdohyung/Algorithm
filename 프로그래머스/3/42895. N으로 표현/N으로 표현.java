import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            Set<Integer> now = dp.get(i);
            int r = Integer.parseInt(String.valueOf(N).repeat(i));
            now.add(r);

            for (int j = 1; j < i; j++) {
                Set<Integer> aSet = dp.get(j);
                Set<Integer> bSet = dp.get(i - j);

                for (int a : aSet) {
                    for (int b : bSet) {
                        now.add(a + b);
                        now.add(a - b);
                        now.add(a * b);
                        if (b != 0) now.add(a / b);
                    }
                }
            }

            if (now.contains(number)) return i;
        }

        return -1;
    }
}
