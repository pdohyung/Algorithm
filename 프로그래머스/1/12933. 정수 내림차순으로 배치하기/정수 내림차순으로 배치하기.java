import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");

        Arrays.sort(digits, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }

        return Long.parseLong(sb.toString());
    }
}